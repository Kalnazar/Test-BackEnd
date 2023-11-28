package com.kalnazar.test.controller;

import com.kalnazar.test.model.Specialist;
import com.kalnazar.test.model.dto.LoginDTO;
import com.kalnazar.test.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/specialist/")
public class SpecialistController {
    private final SpecialistService specialistService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public SpecialistController(SpecialistService specialistService, PasswordEncoder passwordEncoder) {
        this.specialistService = specialistService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginSpecialist(@RequestBody LoginDTO loginDTO) {
        Specialist specialist = specialistService.findSpecialistByEmail(loginDTO.getEmail());
        if (specialist != null && passwordEncoder.matches(loginDTO.getPassword(), specialist.getPassword())) {
            return ResponseEntity.ok(specialist);
        } else {
            return (ResponseEntity<?>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Specialist> registerSpecialist(@RequestBody Specialist specialist) {
        specialist.setPassword(passwordEncoder.encode(specialist.getPassword()));
        Specialist newSpecialist = specialistService.saveSpecialist(specialist);
        return new ResponseEntity<>(newSpecialist, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Specialist>> getAllEmployee() {
        List<Specialist> specialists = specialistService.findAllSpecialists();
        return new ResponseEntity<>(specialists, HttpStatus.OK);
    }

}
