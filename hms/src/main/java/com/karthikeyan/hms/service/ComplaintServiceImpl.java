package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.Complaint;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService{
    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintsByStudent(Student student) {
        return complaintRepository.findByStudent(student);
    }

    @Override
    public List<Complaint> getComplaintByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}
