package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

import java.util.ArrayList;

import java.util.Random;

public class CentreManager {
    public static ArrayList<TraineeCentre> openCentres = new ArrayList<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;


    
    public static TraineeCentre createCentre()
    {

        TraineeCentre centre = new TraineeCentre();
        openCentres.add(centre);
        return centre;
    }

    public static TraineeCentre createCentre(int cap)
    {

        TraineeCentre centre = new TraineeCentre(cap);
        openCentres.add(centre);
        return centre;
    }

    public static boolean isFull(int centreId)
    {
        if(openCentres.get(centreId).getCentreStatus() == TraineeCentre.CentreStatus.FULL)
        {
            numberOfFullCentres++;
            return true;
        }
        return false;
    }

    public static int getTrainees() {
        int countTrainees = 0;

        for (TraineeCentre centre: openCentres) {
            countTrainees += centre.getCurrentCapacity();
        }
        totalNumberOfTrainees = countTrainees;
        return countTrainees;
    }



    private static int generateNumberOfTrainees(){
        Random random = new Random();
        int randomNumber = random.nextInt(21);
        return randomNumber;
    }



    public static void addTrainee(TraineeCentre traineeCentre, Trainee trainee){

        if (WaitingList.getWaitingListSize()!= 0 ){
            WaitingList.addTraineesToCentre(traineeCentre,generateNumberOfTrainees());
        }

    }


}