package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.ParentVisitRequest;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.repository.ParentVisitRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentVisitRequestServiceImpl implements ParentVisitRequestService{

    private final ParentVisitRequestRepository parentVisitRequestRepository;

    @Autowired
    public ParentVisitRequestServiceImpl(ParentVisitRequestRepository parentVisitRequestRepository) {
        this.parentVisitRequestRepository = parentVisitRequestRepository;
    }

    @Override
    public ParentVisitRequest submitRequest(ParentVisitRequest request) {
        return parentVisitRequestRepository.save(request);
    }

    @Override
    public List<ParentVisitRequest> getRequestsByStudent(Student student) {
        return parentVisitRequestRepository.findByStudent(student);
    }

    @Override
    public List<ParentVisitRequest> getAllRequests() {
        return parentVisitRequestRepository.findAll();
    }

    @Override
    public Optional<ParentVisitRequest> getRequestById(Long id) {
        return parentVisitRequestRepository.findById(id);
    }

    @Override
    public ParentVisitRequest updateRequest(ParentVisitRequest request) {
        return parentVisitRequestRepository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        parentVisitRequestRepository.deleteById(id);
    }
}
