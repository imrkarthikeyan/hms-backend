package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    Optional<Student> getStudentById(Long id);
    Optional<Student> getStudentByFirebaseUid(String firebaseUid);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
