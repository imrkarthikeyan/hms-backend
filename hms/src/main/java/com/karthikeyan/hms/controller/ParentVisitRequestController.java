package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.ParentVisitRequest;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.service.ParentVisitRequestService;
import com.karthikeyan.hms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parent-visits")
@CrossOrigin(origins = "*")
public class ParentVisitRequestController {

    private final ParentVisitRequestService visitService;
    private final StudentService studentService;

    @Autowired
    public ParentVisitRequestController(ParentVisitRequestService visitService, StudentService studentService) {
        this.visitService = visitService;
        this.studentService = studentService;
    }

    @PostMapping("/student/{studentId}")
    public ParentVisitRequest submitRequest(@PathVariable Long studentId, @RequestBody ParentVisitRequest request) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if (studentOpt.isPresent()) {
            request.setStudent(studentOpt.get());
            request.setRequestDate(LocalDate.now());
            request.setStatus("Pending");
            return visitService.submitRequest(request);
        }
        throw new RuntimeException("Student not found");
    }

    @GetMapping
    public List<ParentVisitRequest> getAllRequests() {
        return visitService.getAllRequests();
    }

    @GetMapping("/student/{studentId}")
    public List<ParentVisitRequest> getRequestsByStudent(@PathVariable Long studentId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        return studentOpt.map(visitService::getRequestsByStudent) .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @PutMapping("/{id}")
    public ParentVisitRequest updateRequest(@PathVariable Long id, @RequestBody ParentVisitRequest updatedRequest) {
        updatedRequest.setId(id);
        return visitService.updateRequest(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        visitService.deleteRequest(id);
    }
}
