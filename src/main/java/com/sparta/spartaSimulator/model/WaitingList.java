package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

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


    public static void addAllTrainees(ArrayList<Trainee>  trainees){
        waitingList.addAll(trainees);
    }


    public static int getWaitingListSize(){
        return waitingList.size();
    }


    public static HashSet<Trainee> addTraineesToCentre(Centres traineeCentre, int numberOfTrainees){

        for (int i = 0; i < numberOfTrainees; i++) {
            traineeCentre.addTrainee(waitingList.get(i));
        }

        waitingList.removeAll(traineeCentre.getTrainees());
        return traineeCentre.getTrainees();
    }

    public static int getTrainees(Trainee.TraineeCourse traineeCourse){
        int total = 0;
        for(Trainee trainee:waitingList){
            if(trainee.getTraineeCourse()==traineeCourse){
                total++;
            }
        }
        return total;
    }


}
