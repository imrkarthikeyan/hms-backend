package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.Complaint;
import com.karthikeyan.hms.entity.Student;

import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    Complaint submitComplaint(Complaint complaint);
    Optional<Complaint> getComplaintById(Long id);
    List<Complaint> getAllComplaints();
    List<Complaint> getComplaintsByStudent(Student student);
    List<Complaint> getComplaintByStatus(String status);
    Complaint updateComplaint(Complaint complaint);
    void deleteComplaint(Long id);
}
