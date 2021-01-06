package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.BootCamp;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CentreManager {
    public static ArrayList<Centres> openCentres = new ArrayList<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;
    public static Random random = new Random();

    public static Centres createCentre()
    {
        Centres centre = Factory.centreFactory(randomGeneration());
        if(centre.getClass().getSimpleName().equals("TrainingHub"))
        {
            openCentres.add(Factory.centreFactory(1));
            openCentres.add(Factory.centreFactory(1));
        }
        openCentres.add(centre);
        System.out.println("Centre created:  " + centre.getClass().getSimpleName());
        return centre;
    }

    public static int randomGeneration()
    {
        int count = 0;
        int range = 0;
        for(Centres centre: openCentres)
        {
            if(centre.getClass().getSimpleName().equals("BootCamp"))
            {
                count++;
            }
        }
        if(count > 1)
        {
            range = (2-1)+1;
        }
        else
        {
            range = (3-1)+1;
        }
        return (int)(Math.random() * range) + 1;
    }

    //This Constructor is for testing purposes only
    public static Centres createCentre(int cap) {
        Centres centre = Factory.centreFactory(3);
        //centre.setCentreStatus(TraineeCentre.CentreStatus.FULL);
        openCentres.add(centre);
        return centre;
    }

    public static boolean isFull(Centres centre) {
        return centre.getCentreStatus() == TraineeCentre.CentreStatus.FULL;
    }

    public static int getTrainees() {
        int countTrainees = 0;

        for (Centres centre : openCentres) {
            countTrainees += centre.getCurrentCapacity();
        }
        totalNumberOfTrainees = countTrainees;
        return countTrainees;
    }

    public static int getTrainees(Trainee.TraineeCourse course){
        int countTrainees = 0;

        for (Centres centre: openCentres) {
            for(Trainee trainee: centre.getTrainees()){
                if(trainee.getTraineeCourse() == course){
                    countTrainees++;
                }
            }
        }
        return countTrainees;
    }//returns number of trainees in a particular stream

    private static int generateNumberOfTrainees() {
        Random random = new Random();
        int randomNumber = random.nextInt(21);
        return randomNumber;
    }

    public static void addTrainees(ArrayList<Centres> openCentres) {
        for (Centres openCentre : openCentres) {
            for (int i = 0; i < generateNumberOfTrainees(); i++) {
                addTrainee(openCentre);
            }
        }

        addUnplacedTraineesToWaitingList();
        System.out.println("Current Waiting List size: " + WaitingList.getWaitingListSize());
    }

    public static void addTrainee(Centres openCentre) {

        if (WaitingList.getWaitingListSize() > 0) {

            openCentre.addTrainee(TraineeManager.getTrainee(WaitingList.getWaitingList()));
            //System.out.println("Trainee added from Waiting List");

        } else if (TraineeManager.getUnplacedTrainees().size() > 0) {

            openCentre.addTrainee(TraineeManager.getTrainee(TraineeManager.getUnplacedTrainees()));
            //System.out.println("Trainee added from Unplaced List");

        } else {

            System.out.println("No trainees available for placement");

        }

    }

    public static void addUnplacedTraineesToWaitingList() {
        WaitingList.addAllTrainees(TraineeManager.getUnplacedTrainees());
        TraineeManager.emptyUnplacedTrainees();
    }

    public static void addTrainee(Centres centre, Trainee trainee) {

        if (WaitingList.getWaitingListSize() != 0) {
            WaitingList.addTraineesToCentre(centre, generateNumberOfTrainees());
        }

    }

    public static int getNumberOfFullCentres() {
        for (Centres centre : openCentres) {
            if (CentreManager.isFull(centre)) {
                numberOfFullCentres++;
            }
        }
        return numberOfFullCentres;
    }

    //this method is purely for testing purposes
    public static void destroyAllCentres(){
        openCentres.clear();
    }

}