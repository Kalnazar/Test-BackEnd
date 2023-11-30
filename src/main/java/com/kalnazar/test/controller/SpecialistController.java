package com.kalnazar.test.controller;

import com.kalnazar.test.exception.UserNotFoundException;
import com.kalnazar.test.model.Specialist;
import com.kalnazar.test.model.dto.LoginDTO;
import com.kalnazar.test.service.SpecialistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/specialist/")
public class SpecialistController {
    private final SpecialistService specialistService;

    public SpecialistController(SpecialistService specialistService) {
        this.specialistService = specialistService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginSpecialist(@RequestBody LoginDTO loginDTO) {
        try {
            Specialist specialist = specialistService.findSpecialistByEmail(loginDTO.getEmail());
            if (specialist != null && specialist.getPassword().equals(loginDTO.getPassword())) {
                return ResponseEntity.ok(specialist);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
            }
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        } catch (Exception ex) {
            // Log the exception details for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server error occurred");
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Specialist> registerSpecialist(@RequestBody Specialist specialist) {
        Specialist newSpecialist = specialistService.saveSpecialist(specialist);
        return new ResponseEntity<>(newSpecialist, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Specialist>> getAllEmployee() {
        List<Specialist> specialists = specialistService.findAllSpecialists();
        return new ResponseEntity<>(specialists, HttpStatus.OK);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<Specialist> finSpecialistByEmail(@PathVariable("email") String email) {
        Specialist specialist = specialistService.findSpecialistByEmail(email);
        return new ResponseEntity<>(specialist, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Specialist> updateSpecialist(@RequestBody Specialist specialist) {
        Specialist updatedSpecialist = specialistService.updateSpecialist(specialist);
        return new ResponseEntity<>(updatedSpecialist, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteSpecialistByEmail(@PathVariable("email") String email) {
        specialistService.deleteSpecialistByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
