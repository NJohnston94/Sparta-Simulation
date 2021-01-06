package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Random;

public class CentreManager {
    public static ArrayList<TraineeCentre> openCentres = new ArrayList<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;

    public static TraineeCentre createCentre() {
        TraineeCentre centre = new TraineeCentre();
        openCentres.add(centre);
        return centre;
    }

    public static TraineeCentre createCentre(int cap) {

        TraineeCentre centre = new TraineeCentre(cap);
        openCentres.add(centre);
        return centre;
    }

    public static boolean isFull(int centreId) {
        if (openCentres.get(centreId).getCentreStatus() == TraineeCentre.CentreStatus.FULL) {

            return true;
        }
        return false;
    }

    public static int getTrainees() {
        int countTrainees = 0;

        for (TraineeCentre centre : openCentres) {
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


    public static void addTrainee(TraineeCentre traineeCentre, Trainee trainee) {

        if (WaitingList.getWaitingListSize() != 0) {
            WaitingList.addTraineesToCentre(traineeCentre, generateNumberOfTrainees());
        }

    }


    public static ArrayList<TraineeCentre> getFreeCentres() {
        ArrayList<TraineeCentre> freeCentres = new ArrayList<>();
        for (int i = 0; i < openCentres.size(); i++) {
            if (!isFull(i)) {
                freeCentres.add(openCentres.get(i));
            }
        }
        return freeCentres;
    }

    public static void monthlyCheck() {
        for (int i = 0; i < openCentres.size(); i++) {
            if (openCentres.get(i).getCurrentCapacity() < 25) {
                //and not in safe period!
                deleteCentre(i);
            }

        }

    }

    public static void deleteCentre(int index) {
        HashSet<Trainee> traineesToRelocate = openCentres.get(index).getTrainees();
        openCentres.remove(index);

        relocateTrainees(traineesToRelocate);

    }

    public static void relocateTrainees(HashSet<Trainee> trainees) {
        //method function: takes in hashset of trainees and adds them to free centres. Left overs are added to waiting list
        //TO ADD: check if centre is tech centre (only takes a trainee of certain course)

        System.out.println(trainees.size());
        ArrayList<TraineeCentre> freeCentres = getFreeCentres();

        for (TraineeCentre centre : openCentres) {
            System.out.println("Centre " + centre.getCurrentCapacity());
        }
        HashSet<Trainee> traineesAdded = new HashSet<>();

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
        //add left over to waiting list
        trainees.removeAll(traineesAdded);
        if (trainees.size() > 0) {
            WaitingList.addAllTrainees(trainees);
        }


        for (TraineeCentre centre : openCentres) {
            System.out.println("Centre " + centre.getCurrentCapacity());

        }
        System.out.println(WaitingList.getWaitingListSize());

    }
}