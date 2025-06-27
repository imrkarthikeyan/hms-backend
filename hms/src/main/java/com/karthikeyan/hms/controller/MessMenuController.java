package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.MessMenu;
import com.karthikeyan.hms.service.MessMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mess-menu")
@CrossOrigin(origins = "*")
public class MessMenuController {

    private final MessMenuService messMenuService;

    @Autowired
    public MessMenuController(MessMenuService messMenuService) {
        this.messMenuService = messMenuService;
    }

    @PostMapping
    public MessMenu addOrUpdateMenu(@RequestBody MessMenu messMenu) {
        return messMenuService.addOrUpdateMenu(messMenu);
    }

    @GetMapping("/today")
    public Optional<MessMenu> getTodayMenu() {
        return messMenuService.getMenuByDate(LocalDate.now());
    }

    @GetMapping("/date/{date}")
    public Optional<MessMenu> getMenuByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return messMenuService.getMenuByDate(localDate);
    }

    @GetMapping
    public List<MessMenu> getAllMenus() {
        return messMenuService.getAllMenus();
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        messMenuService.deleteMenu(id);
    }
}
