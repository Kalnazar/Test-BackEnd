package com.kalnazar.test.repo;

import com.kalnazar.test.model.Specialist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpecialistRepo extends JpaRepository<Specialist, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Specialist s WHERE s.email = :email")
    void deleteSpecialistByEmail(String email);
    Optional<Specialist> findSpecialistByEmail(String email);
}
