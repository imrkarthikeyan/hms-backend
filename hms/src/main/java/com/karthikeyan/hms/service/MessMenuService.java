package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.MessMenu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MessMenuService {
    MessMenu addOrUpdateMenu(MessMenu messMenu);
    Optional<MessMenu> getMenuByDate(LocalDate date);
    List<MessMenu> getAllMenus();
    void deleteMenu(Long id);
}
