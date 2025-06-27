package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.Warden;

import java.util.List;
import java.util.Optional;

public interface WardenService {
    Warden saveWarden(Warden warden);
    Optional<Warden> getWardenById(Long id);
    Optional<Warden> getWardenByFirebaseUid(String firebaseUid);
    List<Warden> getAllWardens();
    Warden updateWarden(Warden warden);
    void deleteWarden(Long id);
}
