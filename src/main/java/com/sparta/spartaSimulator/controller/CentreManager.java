package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

import java.util.ArrayList;

import java.util.Random;

public class CentreManager {
    public static ArrayList<Centres> openCentres = new ArrayList<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;


    
    public static Centres createCentre()
    {
        Centres centre = Factory.centreFactory(1);
        openCentres.add(centre);
        return centre;
    }

    //This Constructor is for testing purposes only
    public static Centres createCentre(int cap)
    {
        Centres centre = Factory.centreFactory(1);
        centre.setCentreStatus(TraineeCentre.CentreStatus.FULL);
        openCentres.add(centre);
        return centre;
    }

    public static boolean isFull(Centres centre)
    {
        if(centre.getCentreStatus() == TraineeCentre.CentreStatus.FULL)
        {
            return true;
        }
        return false;
    }

    public static int getTrainees() {
        int countTrainees = 0;

        for (Centres centre: openCentres) {
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

    public static void addTrainee(Centres centre, Trainee trainee){

        if (WaitingList.getWaitingListSize()!= 0 ){
            WaitingList.addTraineesToCentre(centre,generateNumberOfTrainees());
        }

    }

    public static int getNumberOfFullCentres()
    {
        for(Centres centre: openCentres)
        {
            if(CentreManager.isFull(centre))
            {
                numberOfFullCentres++;
            }
        }
        return numberOfFullCentres;
    }


}