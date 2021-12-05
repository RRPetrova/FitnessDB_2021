package com.example.fitnessdb.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddNewTrainerBindingModel {
    public String name;
    public String experience;
    public String headingTrainer;
    public String trainerPictureUrl;
    public LocalDate dateOfBirth;


    public AddNewTrainerBindingModel() {
    }

    @Pattern(regexp = "[A-Za-z ]*", message = "Must contains only letters")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    @NotBlank(message = "Field cannot be blank.")
    public String getName() {
        return name;
    }

    public AddNewTrainerBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3, max = 50, message = "Experience must be between 3 and 50 symbols.")
    @NotBlank(message = "Field cannot be blank.")
    public String getExperience() {
        return experience;
    }

    public AddNewTrainerBindingModel setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    @Pattern(regexp = "[A-Za-z ]*", message = "Must contains only letters")
    @Size(min = 3, max = 20, message = "Heading must be between 3 and 20 symbols.")
    @NotBlank(message = "Field cannot be blank.")
    public String getHeadingTrainer() {
        return headingTrainer;
    }

    public AddNewTrainerBindingModel setHeadingTrainer(String headingTrainer) {
        this.headingTrainer = headingTrainer;
        return this;
    }

    @Pattern(regexp = "^https?://.*", message = "Invalid url type")
    @Size(min = 3, max = 200, message = "Picture URL must be between 3 and 200 symbols.")
    @NotBlank(message = "Field cannot be blank.")
    public String getTrainerPictureUrl() {
        return trainerPictureUrl;
    }

    public AddNewTrainerBindingModel setTrainerPictureUrl(String trainerPictureUrl) {
        this.trainerPictureUrl = trainerPictureUrl;
        return this;
    }

    @Past(message = "Please enter a valid date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public AddNewTrainerBindingModel setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
