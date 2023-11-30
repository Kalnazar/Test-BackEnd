package com.kalnazar.test.repo;

import com.kalnazar.test.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialistRepo extends JpaRepository<Specialist, Integer> {
    void deleteSpecialistByEmail(String email);
    Optional<Specialist> findSpecialistByEmail(String email);
}
