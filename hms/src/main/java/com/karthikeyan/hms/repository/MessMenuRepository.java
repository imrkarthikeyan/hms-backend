package com.karthikeyan.hms.repository;

import com.karthikeyan.hms.entity.MessMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface MessMenuRepository extends JpaRepository<MessMenu, Long> {
    Optional<MessMenu> findByDate(LocalDate date);
}
