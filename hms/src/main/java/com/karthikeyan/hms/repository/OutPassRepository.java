package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.OutPass;
import com.karthikeyan.hms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutPassRepository extends JpaRepository<OutPass, Long>{
    List<OutPass> findByStudent(Student student);
    List<OutPass> findByStatus(String status);
}
