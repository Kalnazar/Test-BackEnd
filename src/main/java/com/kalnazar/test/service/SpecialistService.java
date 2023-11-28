package com.kalnazar.test.service;

import com.kalnazar.test.exception.UserNotFoundException;
import com.kalnazar.test.model.Specialist;
import com.kalnazar.test.repo.SpecialistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistService {
    private final SpecialistRepo specialistRepo;

    @Autowired
    public SpecialistService(SpecialistRepo specialistRepo) {
        this.specialistRepo = specialistRepo;
    }

    public List<Specialist> findAllSpecialists() {
        return specialistRepo.findAll();
    }

    public Specialist saveSpecialist(Specialist specialist) {
        return specialistRepo.save(specialist);
    }

    public Specialist updateSpecialist(Specialist specialist) {
        return specialistRepo.save(specialist);
    }

    public Specialist findSpecialistByEmail(String email) {
        return specialistRepo.findSpecialistByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User by email " + email + " was not found!"));
    }

    public void deleteSpecialistById(int id) {
        specialistRepo.deleteSpecialistById(id);
    }

}
