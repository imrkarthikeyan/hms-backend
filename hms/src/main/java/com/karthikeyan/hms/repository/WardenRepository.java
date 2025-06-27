package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.Warden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WardenRepository extends JpaRepository<Warden, Long> {
    Optional<Warden> findByFirebaseUid(String firebaseUid);
}
