package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.FeesUpdateRequest;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.repository.FeesUpdateRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesUpdateRequestServiceImpl implements FeesUpdateRequestService{
    private FeesUpdateRequestRepository feesUpdateRequestRepository;

    @Autowired
    public FeesUpdateRequestServiceImpl(FeesUpdateRequestRepository feesUpdateRequestRepository) {
        this.feesUpdateRequestRepository = feesUpdateRequestRepository;
    }

    @Override
    public FeesUpdateRequest submitRequest(FeesUpdateRequest request) {
        return feesUpdateRequestRepository.save(request);
    }

    @Override
    public List<FeesUpdateRequest> getRequestsByStudent(Student student) {
        return feesUpdateRequestRepository.findByStudent(student);
    }

    @Override
    public List<FeesUpdateRequest> getRequestsByStatus(String status) {
        return feesUpdateRequestRepository.findByStatus(status);
    }

    @Override
    public List<FeesUpdateRequest> getAllRequests() {
        return feesUpdateRequestRepository.findAll();
    }

    @Override
    public Optional<FeesUpdateRequest> getRequestById(Long id) {
        return feesUpdateRequestRepository.findById(id);
    }

    @Override
    public FeesUpdateRequest updateRequest(FeesUpdateRequest request) {
        return feesUpdateRequestRepository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        feesUpdateRequestRepository.deleteById(id);
    }
}
