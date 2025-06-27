package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.FeesUpdateRequest;
import com.karthikeyan.hms.entity.Student;

import java.util.List;
import java.util.Optional;

public interface FeesUpdateRequestService {
    FeesUpdateRequest submitRequest(FeesUpdateRequest request);
    List<FeesUpdateRequest> getRequestsByStudent(Student student);
    List<FeesUpdateRequest> getRequestsByStatus(String status);
    List<FeesUpdateRequest> getAllRequests();
    Optional<FeesUpdateRequest> getRequestById(Long id);
    FeesUpdateRequest updateRequest(FeesUpdateRequest request);
    void deleteRequest(Long id);
}
