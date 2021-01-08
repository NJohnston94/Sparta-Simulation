package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Bench;
import com.sparta.spartaSimulator.model.PropertiesReader;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TrainingCourse;

import java.util.ArrayList;
import java.util.HashSet;

public class TraineeManager {

    private static final int MIN_TRAINEES = PropertiesReader.getMinTraineesCreated();
    private static final int MAX_TRAINEES = PropertiesReader.getMaxTraineesCreated();
    private static final int RANGE = MAX_TRAINEES-MIN_TRAINEES+1;

    //Made this public for testing purposes in TechCentreTests || change back when happy
    public static ArrayList<Trainee> unplacedTrainees = new ArrayList<>();

    public static Trainee[] createTrainees(int randomNumber){
        //done as array as size is passed through, but can be changed to what is used in other classes

        Trainee[] result = new Trainee[randomNumber];
        for(int i = 0; i < randomNumber; i++){
            result[i] = new Trainee();
        }
        return result;
    }

    public static ArrayList<Trainee> getUnplacedTrainees() {
        return unplacedTrainees;
    }

    public static void emptyUnplacedTrainees() {
        unplacedTrainees.clear();
    }

    public static HashSet<Trainee> createTrainees(){

        HashSet<Trainee> newTrainees = new HashSet<>();
        int randomNumber = generateRandomNumber(MIN_TRAINEES,MAX_TRAINEES);

        for(int i = 0; i < randomNumber; i++){
            newTrainees.add(new Trainee());
        }

        unplacedTrainees.addAll(newTrainees);
        return newTrainees;
    }//generates between min and max inclusive new Trainees and puts them in a hashmap to be returned

    private static int generateRandomNumber(int min,int max){
        int range = (max-min)+1;
        int randomNumber = (int)(Math.random() * range) + min;
        return randomNumber;
    }

    public static Trainee getTrainee(ArrayList<Trainee> traineeList) {
        Trainee trainee = traineeList.get(0);
        traineeList.remove(trainee);
        return trainee;
    }

    public static Trainee getTraineeTechCentre(ArrayList<Trainee> traineeList, TrainingCourse.CourseType trainingCourse) {
        Trainee trainee = traineeList.get(0);
        for(Trainee trainees: traineeList)
        {
            if(trainee.getTraineeCourse() == trainingCourse)
            {
                traineeList.remove(trainees);
                return trainees;
            }
        }
        return trainee;
    }

    public static void updateTraineeMonthsInTraining() {
        ArrayList<Trainee> traineesToRemoveFromCentres = new ArrayList<>();

        for(Trainee trainee:CentreManager.getPlacedTrainees()) {
            trainee.setMonthsInTraining(trainee.getMonthsInTraining() + 1);
            if(trainee.getMonthsInTraining() == 12) {
                Bench.addTrainees(trainee);
                traineesToRemoveFromCentres.add(trainee);
            }
        }

        CentreManager.getPlacedTrainees().removeAll(traineesToRemoveFromCentres);
    }
}
