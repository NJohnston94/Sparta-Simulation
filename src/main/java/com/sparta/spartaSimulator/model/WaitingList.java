package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.HashSet;

public class WaitingList {

    private ArrayList<Trainee> waitingList = new ArrayList<>();


    public ArrayList<Trainee> getWaitingList() {
        return waitingList;
    }

    public void addTrainees(Trainee trainee){
        waitingList.add(trainee);
    }


    public void addAllTrainees(HashSet<Trainee>  trainees){
        waitingList.addAll(trainees);
    }


    public int getWaitingListSize(){
        return waitingList.size();
    }


    public HashSet<Trainee> addTraineesToCentre(TraineeCentre traineeCentre, int numberOfTrainees){

        for (int i = 0; i < numberOfTrainees; i++) {
            traineeCentre.addTrainee(waitingList.get(i));
        }

        waitingList.removeAll(traineeCentre.getTrainees());
        return traineeCentre.getTrainees();
    }



}
