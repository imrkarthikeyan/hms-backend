package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.OutPass;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.service.OutPassService;
import com.karthikeyan.hms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/outpass")
@CrossOrigin(origins = "*")
public class OutPassController {
    private final OutPassService outPassService;
    private final StudentService studentService;

    @Autowired
    public OutPassController(OutPassService outPassService, StudentService studentService) {
        this.outPassService = outPassService;
        this.studentService = studentService;
    }

    @PostMapping("/student/{studentId}")
    public OutPass submitOutPass(@PathVariable Long studentId, @RequestBody OutPass outPass){
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if(studentOpt.isPresent()){
            outPass.setStudent(studentOpt.get());
            outPass.setStatus("PENDING");
            if(outPass.getReason() == null || outPass.getStartFrom() == null || outPass.getEndTo() == null) {
                throw new RuntimeException("Reason, start date, and end date cannot be null");
            }
            return outPassService.submitOutPass(outPass);
        }
        throw new RuntimeException("Student not found");
    }

    @GetMapping
    public List<OutPass> getAllOutPasses() {
        return outPassService.getAllOutPass();
    }

    @GetMapping("/student/{studentId}")
    public List<OutPass> getOutPassByStudent(@PathVariable Long studentId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        return studentOpt.map(outPassService::getOutPassByStudent)
                         .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @GetMapping("/status/{status}")
    public List<OutPass> getOutPassByStatus(String status) {
        return outPassService.getOutPassByStatus(status.toUpperCase());
    }

    @PutMapping("/{id}")
    public OutPass updateOutPass(@PathVariable Long id, @RequestBody OutPass outPass){
        outPass.setId(id);
        return outPassService.updateOutPass(outPass);
    }

    public void deleteOutPass(@PathVariable Long id) {
        outPassService.deleteOutPass(id);
    }
}
