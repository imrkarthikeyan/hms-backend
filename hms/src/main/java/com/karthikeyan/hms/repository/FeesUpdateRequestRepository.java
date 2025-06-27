package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.FeesUpdateRequest;
import com.karthikeyan.hms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeesUpdateRequestRepository extends JpaRepository<FeesUpdateRequest, Long> {
    List<FeesUpdateRequest> findByStudent(Student student);
    List<FeesUpdateRequest> findByStatus(String status);
}
