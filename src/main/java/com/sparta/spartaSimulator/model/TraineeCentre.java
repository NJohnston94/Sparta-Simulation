package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.CreationInt;

import java.util.HashSet;

public class TraineeCentre implements CreationInt {

    private HashSet<Trainee> allTrainees = new HashSet<>();
    private final static int MAX_CAPACITY = 100;
    private CentreStatus centreStatus;

    public enum CentreStatus{
        FULL,
        NEARLY_FULL,
        NOT_FULL
    }

    public TraineeCentre() {
        this.centreStatus = CentreStatus.NOT_FULL;
    }

    public CentreStatus getCentreStatus() {
        return centreStatus;
    }

    private void setCentreStatus(CentreStatus centreStatus) {
        this.centreStatus = centreStatus;
    }

    private void checkCentreStatus() {
        if(allTrainees.size() == MAX_CAPACITY) {
            setCentreStatus(CentreStatus.FULL);
        } else if (allTrainees.size() >= 80) {
            setCentreStatus(CentreStatus.NEARLY_FULL);
        }
    }

    public void addTrainee(Trainee trainee){
        allTrainees.add(trainee);
        checkCentreStatus();
    }

    public void addAllTrainees(HashSet<Trainee> trainees) {
        allTrainees.addAll(trainees);
        checkCentreStatus();
    }

    public int getCurrentCapacity() {
        return allTrainees.size();
    }

    public static int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public HashSet<Trainee> getTrainees(){
        return allTrainees;
    }




}
