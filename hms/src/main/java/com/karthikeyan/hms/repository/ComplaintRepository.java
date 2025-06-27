package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.Complaint;
import com.karthikeyan.hms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{
    List<Complaint> findByStudent(Student student);
    List<Complaint> findByStatus(String status);
}
