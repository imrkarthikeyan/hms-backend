package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByFirebaseUid(String firebaseUid);
}
