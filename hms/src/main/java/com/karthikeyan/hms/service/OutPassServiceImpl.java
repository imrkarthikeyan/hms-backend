package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.OutPass;
import com.karthikeyan.hms.entity.Student;
import com.karthikeyan.hms.repository.OutPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutPassServiceImpl implements OutPassService{
    private final OutPassRepository outPassRepository;

    @Autowired
    public OutPassServiceImpl(OutPassRepository outPassRepository) {
        this.outPassRepository = outPassRepository;
    }

    @Override
    public OutPass submitOutPass(OutPass outPass) {
        return outPassRepository.save(outPass);
    }

    @Override
    public Optional<OutPass> getOutPassById(Long id) {
        return outPassRepository.findById(id);
    }

    @Override
    public List<OutPass> getAllOutPass() {
        return outPassRepository.findAll();
    }

    @Override
    public List<OutPass> getOutPassByStudent(Student student) {
        return outPassRepository.findByStudent(student);
    }

    @Override
    public List<OutPass> getOutPassByStatus(String status) {
        return outPassRepository.findByStatus(status);
    }

    @Override
    public OutPass updateOutPass(OutPass outPass) {
        return outPassRepository.save(outPass);
    }

    @Override
    public void deleteOutPass(Long id) {
        outPassRepository.deleteById(id);
    }
}
