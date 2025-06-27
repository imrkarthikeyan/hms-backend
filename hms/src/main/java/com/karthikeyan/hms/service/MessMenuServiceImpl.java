package com.karthikeyan.hms.service;

import com.karthikeyan.hms.entity.MessMenu;
import com.karthikeyan.hms.repository.MessMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MessMenuServiceImpl implements MessMenuService{
    private final MessMenuRepository messMenuRepository;

    @Autowired
    public MessMenuServiceImpl(MessMenuRepository messMenuRepository) {
        this.messMenuRepository = messMenuRepository;
    }

    @Override
    public MessMenu addOrUpdateMenu(MessMenu messMenu) {
        return messMenuRepository.save(messMenu);
    }

    @Override
    public Optional<MessMenu> getMenuByDate(LocalDate date) {
        return messMenuRepository.findByDate(date);
    }

    @Override
    public List<MessMenu> getAllMenus() {
        return messMenuRepository.findAll();
    }

    @Override
    public void deleteMenu(Long id) {
        messMenuRepository.deleteById(id);
    }
}
