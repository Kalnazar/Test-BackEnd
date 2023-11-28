package com.kalnazar.test.service;

import com.kalnazar.test.repo.SpecialistRepo;

public class SpecialistService {
    private final SpecialistRepo specialistRepo;

    public SpecialistService(SpecialistRepo specialistRepo) {
        this.specialistRepo = specialistRepo;
    }


}
