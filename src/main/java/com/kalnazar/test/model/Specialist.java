package com.kalnazar.test.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;
    private Date dateOfBirth;
    private String location;
    private String education;
    private String occupation;
    @ElementCollection
    private List<String> professionalSkills;
    private String phoneNumber;
    @Column(nullable = false)
    private String password;

    public Specialist() {

    }

    public Specialist(String fullName, String email, Date dateOfBirth, String location, String education, String occupation, List<String> professionalSkills, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.education = education;
        this.occupation = occupation;
        this.professionalSkills = professionalSkills;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public List<String> getProfessionalSkills() {
        return professionalSkills;
    }

    public void setProfessionalSkills(List<String> professionalSkills) {
        this.professionalSkills = professionalSkills;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", location='" + location + '\'' +
                ", education='" + education + '\'' +
                ", occupation='" + occupation + '\'' +
                ", professionalSkills=" + professionalSkills +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
