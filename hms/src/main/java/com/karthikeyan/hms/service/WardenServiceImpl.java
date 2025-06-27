package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.Warden;
import com.karthikeyan.hms.repository.WardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardenServiceImpl implements WardenService{
   private final WardenRepository wardenRepository;

    @Autowired
    public WardenServiceImpl(WardenRepository wardenRepository) {
         this.wardenRepository = wardenRepository;
    }

    @Override
    public Warden saveWarden(Warden warden) {
        return wardenRepository.save(warden);
    }

    @Override
    public Optional<Warden> getWardenById(Long id) {
        return wardenRepository.findById(id);
    }

    @Override
    public Optional<Warden> getWardenByFirebaseUid(String firebaseUid) {
        return wardenRepository.findByFirebaseUid(firebaseUid);
    }

    @Override
    public List<Warden> getAllWardens() {
        return wardenRepository.findAll();
    }

    @Override
    public Warden updateWarden(Warden warden) {
        return wardenRepository.save(warden);
    }

    @Override
    public void deleteWarden(Long id) {
        wardenRepository.deleteById(id);
    }
}
