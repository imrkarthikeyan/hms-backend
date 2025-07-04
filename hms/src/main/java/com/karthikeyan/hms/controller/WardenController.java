package com.karthikeyan.hms.controller;

import com.karthikeyan.hms.entity.Warden;
import com.karthikeyan.hms.service.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wardens")
@CrossOrigin(origins = "*")
public class WardenController {
    private final WardenService wardenService;

    @Autowired
    public WardenController(WardenService wardenService){
        this.wardenService=wardenService;
    }

    //signup
    @PostMapping
    public Warden saveWarden(@RequestBody Warden warden){
        return wardenService.saveWarden(warden);
    }

    @GetMapping("/{id}")
    public Optional<Warden> getWardenById(@PathVariable Long id) {
        return wardenService.getWardenById(id);
    }

    @GetMapping("/firebase/{firebaseUid}")
    public Warden getWardenByFirebaseUid(@PathVariable String firebaseUid) {
        return wardenService.getWardenByFirebaseUid(firebaseUid).orElseThrow(() -> new RuntimeException("Warden not found"));
    }


    @GetMapping
    public List<Warden> getAllWardens() {
        return wardenService.getAllWardens();
    }

    @PutMapping("/{id}")
    public Warden updateWarden(@PathVariable Long id, @RequestBody Warden warden) {
        warden.setId(id);
        return wardenService.updateWarden(warden);
    }

    @DeleteMapping("/{id}")
    public void deleteWarden(@PathVariable Long id) {
        wardenService.deleteWarden(id);
    }


}
