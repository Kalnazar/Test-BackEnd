package com.kalnazar.test.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String fullName;
    private String username;
    private Date dateOfBirth;
    private String location;
    private String education;
    private String occupation;
    @ElementCollection
    private List<String> professionalSkills;
    private String phoneNumber;

    public Specialist() {

    }

    public Specialist(String fullName, String username, Date dateOfBirth, String location, String education, String occupation, List<String> professionalSkills, String phoneNumber) {
        this.fullName = fullName;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.education = education;
        this.occupation = occupation;
        this.professionalSkills = professionalSkills;
        this.phoneNumber = phoneNumber;
    }
}
