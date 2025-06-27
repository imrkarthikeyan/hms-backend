package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.ParentVisitRequest;
import com.karthikeyan.hms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentVisitRequestRepository extends JpaRepository<ParentVisitRequest, Long> {
    List<ParentVisitRequest> findByStudent(Student student);
}
