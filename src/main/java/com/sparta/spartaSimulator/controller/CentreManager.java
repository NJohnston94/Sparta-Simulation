package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class CentreManager {
    public static ArrayList<Centres> openCentres = new ArrayList<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;
    public static Random random = new Random();

    public static Centres createCentre()
    {
        Centres centre = Factory.centreFactory(randomGeneration());
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
        int ran = (int)(Math.random() * range) + 1;
        return ran;
    }

    //This Constructor is for testing purposes only
    public static Centres createCentre(int cap) {
        Centres centre = Factory.centreFactory(1);
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
            System.out.println("Trainee added from Waiting List");

        } else if (TraineeManager.getUnplacedTrainees().size() > 0) {

            openCentre.addTrainee(TraineeManager.getTrainee(TraineeManager.getUnplacedTrainees()));
            System.out.println("Trainee added from Unplaced List");

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


    public static void addCentreToOpenCentres(Centres centre){
        openCentres.add(centre);
    }

    public static ArrayList<Centres> getFreeCentres() {
        ArrayList<Centres> freeCentres = new ArrayList<>();
        for(Centres centre :openCentres) {
            if (!isFull(centre)) {
                freeCentres.add(centre);
            }
        }
        return freeCentres;
    }

    public static void monthlyCheck() {
        ArrayList<Centres> toDelete = getCentresToDelete();

        for(Centres centre : toDelete){
            deleteCentre(centre);
            toDelete = getCentresToDelete();
            if(toDelete.size() == 0){
                break;
            }

        }
    }

    public static ArrayList<Centres> getCentresToDelete(){
        ArrayList<Centres> toDelete = new ArrayList<>();

        for(Centres centre :openCentres) {
            //System.out.println("OPEN CENTRES : " + centre.getCurrentCapacity());
            if (centre.getCurrentCapacity() < 25) {
                //and not in safe period!
                toDelete.add(centre);
            }

        }
        return toDelete;
    }

    public static void deleteCentre(Centres centre) {
        System.out.println("DELETE CALLED with centre capacity: "+ centre.getCurrentCapacity());
        HashSet<Trainee> traineesToRelocate = centre.getTrainees();
        openCentres.remove(centre);

        relocateTrainees(traineesToRelocate);
    }

    public static void relocateTrainees(HashSet<Trainee> trainees) {
        //method function: takes in hashset of trainees and adds them to free centres. Left overs are added to waiting list
        //TO ADD: check if centre is tech centre (only takes a trainee of certain course)

        ArrayList<Centres> freeCentres = getFreeCentres();
        HashSet<Trainee> traineesAdded = new HashSet<>();

//        for(Centres centres: openCentres){
//            System.out.println("OPEN CENTRE : " + centres.getCurrentCapacity());
//        }
//
//        for(Centres centres: freeCentres){
//            System.out.println("FREE Centre " + centres.getCurrentCapacity());
//        }

        if (freeCentres.size() > 0) {
            for (Trainee trainee : trainees) {
                Random random = new Random();
                int centreToAdd = random.nextInt(freeCentres.size());

                //add in check is centre is suitable for trainee
                openCentres.get(openCentres.indexOf(freeCentres.get(centreToAdd))).addTrainee(trainee);
                traineesAdded.add(trainee);
                freeCentres = getFreeCentres();

                if (freeCentres.size() == 0) {
                    break;
                }
            }

        }

//        for(Centres centres: openCentres){
//            System.out.println("OPEN CENTRE after reallocation : " + centres.getCurrentCapacity());
//        }

        //add left over to waiting list
        trainees.removeAll(traineesAdded);
        if (trainees.size() > 0) {
            ArrayList<Trainee> traineeArrayList = new ArrayList<>(trainees);
            WaitingList.addAllTrainees(traineeArrayList);
        }

    }



}