package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.HashSet;

public class WaitingList {

    private static ArrayList<Trainee> waitingList = new ArrayList<>();


    public static ArrayList<Trainee> getWaitingList() {
        return waitingList;
    }

    public static void addTrainees(Trainee trainee){
        waitingList.add(trainee);
    }


    public static void addAllTrainees(HashSet<Trainee>  trainees){
        waitingList.addAll(trainees);
    }


    public static int getWaitingListSize(){
        return waitingList.size();
    }


    public static HashSet<Trainee> addTraineesToCentre(TraineeCentre traineeCentre, int numberOfTrainees){

        for (int i = 0; i < numberOfTrainees; i++) {
            traineeCentre.addTrainee(waitingList.get(i));
        }

        waitingList.removeAll(traineeCentre.getTrainees());
        return traineeCentre.getTrainees();
    }



}
