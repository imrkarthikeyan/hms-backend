package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.FeesUpdateRequest;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.service.FeesUpdateRequestService;
import com.karthikeyan.hms.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fees-requests")
@CrossOrigin(origins = "*")
public class FeesUpdateRequestController {

    private final FeesUpdateRequestService feesUpdateRequestService;
    private final StudentService studentService;

    public FeesUpdateRequestController(FeesUpdateRequestService feesUpdateRequestService, StudentService studentService){
        this.feesUpdateRequestService=feesUpdateRequestService;
        this.studentService=studentService;
    }

    @PostMapping("/student/{studentId}")
    public FeesUpdateRequest submitRequest(@PathVariable Long studentId, @RequestBody FeesUpdateRequest request){
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if(studentOpt.isPresent()){
            request.setStudent(studentOpt.get());
            //request.setRequestDate(LocalDateTime.now());
            request.setStatus("Pending");
            return feesUpdateRequestService.submitRequest(request);
        }
        throw new RuntimeException("Student not found");
    }

    @GetMapping
    public List<FeesUpdateRequest> getAllRequests() {
        return feesUpdateRequestService.getAllRequests();
    }

    @GetMapping("/student/{studentId}")
    public List<FeesUpdateRequest> getRequestsByStudent(@PathVariable Long studentId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        return studentOpt.map(feesUpdateRequestService::getRequestsByStudent)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @GetMapping("/status/{status}")
    public List<FeesUpdateRequest> getRequestsByStatus(@PathVariable String status) {
        return feesUpdateRequestService.getRequestsByStatus(status);
    }

    @PutMapping("/{id}")
    public FeesUpdateRequest updateRequest(@PathVariable Long id, @RequestBody FeesUpdateRequest request) {
        request.setId(id);
        return feesUpdateRequestService.updateRequest(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        feesUpdateRequestService.deleteRequest(id);
    }
}
