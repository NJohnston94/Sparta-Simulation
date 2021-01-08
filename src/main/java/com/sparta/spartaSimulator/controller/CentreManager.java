package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.*;
import com.sparta.spartaSimulator.view.LoggerClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class CentreManager {
    public static ArrayList<Centres> openCentres = new ArrayList<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;
    public static Random random = new Random();
    public static int numberOfDeletedCentres = 0;

    public static Centres createCentre()
    {
        Centres centre = Factory.centreFactory(randomGeneration());
        if(centre.getClass().getSimpleName().equals("TrainingHub"))
        {
            Centres trainingHub1 = Factory.centreFactory(1);
            Centres trainingHub2 = Factory.centreFactory(1);

            trainingHub1.setAge(0);
            trainingHub2.setAge(0);

            openCentres.add(trainingHub1);
            openCentres.add(trainingHub2);
        }

        centre.setAge(0);
        openCentres.add(centre);
        //System.out.println("Centre created:  " + centre.getClass().getSimpleName());
        LoggerClass.logTrace("Centre Created of type : " + centre.getClass().getSimpleName());
        return centre;
    }

    public static void updateCentreAge(){

        for (Centres centres : CentreManager.openCentres){
            centres.setAge(centres.getAge()+1);
        }

    }







    public static int randomGeneration()
    {
        int count = 0;
        int range;
        for(Centres centre: openCentres)
        {
            if(centre.getClass().getSimpleName().equals("BootCamp"))
            {
                count++;
            }
        }
        if(count >= PropertiesReader.getMaxNumberOfBootcamps())
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
        Centres centre = Factory.centreFactory(1);
        //centre.setCentreStatus(TraineeCentre.CentreStatus.FULL);
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

    public static int getTrainees(TrainingCourse.CourseType course){
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
        if (openCentres.size()!=0) {

            for (Centres openCentre : openCentres) {

                if (!isFull(openCentre)) {
                    for (int i = 0; i < generateNumberOfTrainees(); i++) {
                        addTrainee(openCentre);
                    }
                }
            }

        }
        addUnplacedTraineesToWaitingList();
        //System.out.println("Current Waiting List size: " + WaitingList.getWaitingListSize());
        LoggerClass.logTrace("Current Waiting List size: " + WaitingList.getWaitingListSize());
    }

    public static void addTrainee(Centres openCentre) {
        if (!isFull(openCentre)) {
        if (WaitingList.getWaitingListSize() > 0) {
            if (openCentre.getClass().getSimpleName().equals("TechCentre")) {
                Trainee trainee = TraineeManager.getTraineeTechCentre(WaitingList.getWaitingList(), openCentre.getCentreCourseType());
                if (trainee != null && trainee.getTraineeCourse() == openCentre.getCentreCourseType()) {
                    openCentre.addTrainee(trainee);
                } else {
                    TraineeManager.getUnplacedTrainees().add(trainee);
                }
            } else {
                openCentre.addTrainee(TraineeManager.getTrainee(WaitingList.getWaitingList()));
            }
            //System.out.println("Trainee added from Waiting List");
                } else if (TraineeManager.getUnplacedTrainees().size() > 0) {

                    openCentre.addTrainee(TraineeManager.getTrainee(TraineeManager.getUnplacedTrainees()));
                    //System.out.println("Trainee added from Unplaced List");

                } else {

                    //System.out.println("No trainees available for placement");
                    LoggerClass.logTrace("No trainees available for placement");

                }
            openCentre.checkCentreStatus();

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

    public static int getNumberOfDeletedCentres(){
        return numberOfDeletedCentres;
    }

    //this method is purely for testing purposes
    public static void destroyAllCentres(){
        openCentres.clear();
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
            numberOfDeletedCentres++;
            toDelete = getCentresToDelete();
            if(toDelete.size() == 0){
                break;
            }

        }
    }

    public static ArrayList<Centres> getCentresToDelete(){
        ArrayList<Centres> toDelete = new ArrayList<>();


        for(Centres centre :openCentres) {
            boolean canDelete = centre.getSafePeriod() < centre.getAge();
            //System.out.println("OPEN CENTRES : " + centre.getCurrentCapacity());
            if (centre.getCurrentCapacity() < 25 && canDelete) {
                //and not in safe period!
                toDelete.add(centre);
            }

        }
        return toDelete;
    }

    public static void deleteCentre(Centres centre) {
        //System.out.println("DELETE CALLED with centre capacity: "+ centre.getCurrentCapacity());
        LoggerClass.logTrace("DELETE CALLED with centre capacity : " + centre.getCurrentCapacity());
        HashSet<Trainee> traineesToRelocate = centre.getTrainees();
        openCentres.remove(centre);


        relocateTrainees(traineesToRelocate);
    }

    public static int getNumberOfOpenCentres(){
        return openCentres.size();
    }

    public static int getNumberOfOpenCentres(String course){
        int count = 0;
        for(Centres centre: openCentres){
            if(centre.getClass().getSimpleName().equals(course)){
                count++;
            }
        }
        return count;
    }

    public static void relocateTrainees(HashSet<Trainee> trainees) {
        //method function: takes in hashset of trainees and adds them to free centres. Left overs are added to waiting list
        //TO ADD: check if centre is tech centre (only takes a trainee of certain course)

        ArrayList<Centres> freeCentres = getFreeCentres();
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
            ArrayList<Trainee> traineeArrayList = new ArrayList<>(trainees);
            WaitingList.addAllTrainees(traineeArrayList);
        }

    }

    public static ArrayList<Trainee> getPlacedTrainees() {
        ArrayList<Trainee> placedTrainees = new ArrayList<>();
        for(Centres centre:openCentres) {
            placedTrainees.addAll(centre.getTrainees());
        }

        return placedTrainees;
    }


}