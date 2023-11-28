package com.kalnazar.test.repo;

import com.kalnazar.test.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepo extends JpaRepository<Specialist, Long> {

}
