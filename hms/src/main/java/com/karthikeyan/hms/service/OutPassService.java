package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.OutPass;
import com.karthikeyan.hms.entity.Student;

import java.util.List;
import java.util.Optional;

public interface OutPassService {
    OutPass submitOutPass(OutPass outPass);
    Optional<OutPass> getOutPassById(Long id);
    List<OutPass> getAllOutPass();
    List<OutPass> getOutPassByStudent(Student student);
    List<OutPass> getOutPassByStatus(String status);
    OutPass updateOutPass(OutPass outPass);
    void deleteOutPass(Long id);
}
