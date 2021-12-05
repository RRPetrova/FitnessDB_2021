package com.example.fitnessdb.service;

import com.example.fitnessdb.model.binding.AddNewTrainerBindingModel;
import com.example.fitnessdb.model.dto.TrainerDto;
import com.example.fitnessdb.model.entity.TrainerEntity;

import java.io.IOException;
import java.util.List;

public interface TrainerService {

   void seedTrainers() throws IOException;

   TrainerEntity findById(Long trainerId);

    TrainerEntity findByName(String trainerName);

    List<String> getAllTrainerNames();


    boolean trainerAlreadyExists(String name);

    void addTrainer(AddNewTrainerBindingModel addNewTrainerBindingModel);

    List<String> getAllFreeTrainersNames();
    List<TrainerDto> getAllFreeTrainers();

    void removeTrainerById(Long id);
}
