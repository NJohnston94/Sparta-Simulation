package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;

import java.util.HashSet;

public abstract class TraineeCentre {

    private HashSet<Trainee> allTrainees = new HashSet<>();
    private int MAX_CAPACITY;
    private CentreStatus centreStatus;

    public enum CentreStatus{
        FULL,
        //NEARLY_FULL,
        NOT_FULL
    }

    public TraineeCentre() {
        this.centreStatus = CentreStatus.NOT_FULL;
    }

    //Used to test full capacity of centre in CentreManager class and the checkCentreStatus method works as intended
    public TraineeCentre(int cap) {
        for(int i = 0; i < cap;i++)
        {
            Trainee newOne = new Trainee();
            allTrainees.add(newOne);
        }
        checkCentreStatus();
    }

    public CentreStatus getCentreStatus() {
        return centreStatus;
    }

    public void setCentreStatus(CentreStatus centreStatus) {
        this.centreStatus = centreStatus;
    }

    public void checkCentreStatus() {
        if(allTrainees.size() == MAX_CAPACITY) {
            setCentreStatus(CentreStatus.FULL);
        } //else if (allTrainees.size() >= 80) {
//            setCentreStatus(CentreStatus.NEARLY_FULL);
//        }
    }

    public void addTrainee(Trainee trainee){
        if (this.getCentreStatus().equals(CentreStatus.NOT_FULL)) {
            allTrainees.add(trainee);
            checkCentreStatus();
        }
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

    public HashSet<Trainee> getTrainees(){
        return allTrainees;
    }

}
