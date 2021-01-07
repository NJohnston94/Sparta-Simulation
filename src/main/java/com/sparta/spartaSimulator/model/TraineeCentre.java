package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public abstract class TraineeCentre implements Centres {

    private HashSet<Trainee> allTrainees = new HashSet<>();
    private int MAX_CAPACITY;
    private CentreStatus centreStatus;
    private int age;
    private int safePeriod;


    private static final Random RANDOM = new Random();
    private TrainingCourse.CourseType centreCourseType; //TechCentre only

    public enum CentreStatus {
        FULL,
        //NEARLY_FULL,
        NOT_FULL
    }

    public TraineeCentre() {
        this.centreStatus = CentreStatus.NOT_FULL;
    }

    //Used to test full capacity of centre in CentreManager class and the checkCentreStatus method works as intended
    public TraineeCentre(int cap) {
        for (int i = 0; i < cap; i++) {
            Trainee newOne = new Trainee();
            allTrainees.add(newOne);
        }
        checkCentreStatus();
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getSafePeriod() {
        return safePeriod;
    }

    public void setSafePeriod(int safePeriod) {
        this.safePeriod = safePeriod;
    }


    public CentreStatus getCentreStatus() {
        return centreStatus;
    }

    public void setCentreStatus(CentreStatus centreStatus) {
        this.centreStatus = centreStatus;
    }

    public void checkCentreStatus() {
        if (allTrainees.size() == MAX_CAPACITY) {
            setCentreStatus(CentreStatus.FULL);
        } //else if (allTrainees.size() >= 80) {
//            setCentreStatus(CentreStatus.NEARLY_FULL);
//        }
    }

    //Changes to this method to check specialism against centres
    public void addTrainee(Trainee trainee) {
//        if (this.getCentreStatus().equals(CentreStatus.NOT_FULL)) {
//            allTrainees.add(trainee);
//            checkCentreStatus();
//        }
        allTrainees.add(trainee);
        checkCentreStatus();
    }

//    public void addAllTrainees(HashSet<Trainee> trainees) {
//        allTrainees.addAll(trainees);
//        checkCentreStatus();
//    }

    public int getCurrentCapacity() {
        return allTrainees.size();
    }

    public void setMaxCapacity(int maxCapacity) {
        this.MAX_CAPACITY = maxCapacity;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public HashSet<Trainee> getTrainees() {
        return allTrainees;
    }

    public TrainingCourse.CourseType getCentreCourseType() {
        return centreCourseType;
    }

}
