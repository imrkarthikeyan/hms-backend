package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.ParentVisitRequest;
import com.karthikeyan.hms.entity.Student;

import java.util.List;
import java.util.Optional;

public interface ParentVisitRequestService {
    ParentVisitRequest submitRequest(ParentVisitRequest request);
    List<ParentVisitRequest> getRequestsByStudent(Student student);
    List<ParentVisitRequest> getAllRequests();
    Optional<ParentVisitRequest> getRequestById(Long id);
    ParentVisitRequest updateRequest(ParentVisitRequest request);
    void deleteRequest(Long id);
}
