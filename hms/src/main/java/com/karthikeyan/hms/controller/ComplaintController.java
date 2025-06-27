package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.Complaint;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.service.ComplaintService;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final StudentService   studentService;

    @Autowired
    public ComplaintController(ComplaintService complaintService, StudentService studentService) {
        this.complaintService = complaintService;
        this.studentService = studentService;
    }

    @PostMapping("/student/{studentId}")
    public Complaint submitComplaint(@PathVariable Long studentId, @RequestBody Complaint complaint) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if (studentOpt.isPresent()) {
            complaint.setStudent(studentOpt.get());
            complaint.setStatus("Pending");
            complaint.setCreatedAt(LocalDateTime.now());
            return complaintService.submitComplaint(complaint);
        }
        throw new RuntimeException("Student not found");
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/student/{studentId}")
    public List<Complaint> getComplaintsByStudent(@PathVariable Long studentId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        return studentOpt.map(complaintService::getComplaintsByStudent).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @GetMapping("/status/{status}")
    public List<Complaint> getComplaintsByStatus(@PathVariable String status) {
        return complaintService.getComplaintByStatus(status);
    }

    @PutMapping("/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
        complaint.setId(id);
        return complaintService.updateComplaint(complaint);
    }

    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
