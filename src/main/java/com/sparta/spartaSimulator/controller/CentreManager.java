package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.*;
import com.sparta.spartaSimulator.view.LoggerClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class CentreManager {

    private static CentreStatusInfo CSI = new CentreStatusInfo();
    private static RandomGeneratorHub randoms = new RandomGeneratorHub();

    public static Centres createCentre() {
        Centres centre = Factory.centreFactory(RandomGeneratorHub.randomFactoryGen());
        if (centre.getClass().getSimpleName().equals("TrainingHub")) {
            Centres trainingHub1 = Factory.centreFactory(1);
            Centres trainingHub2 = Factory.centreFactory(1);

            trainingHub1.setAge(0);
            trainingHub2.setAge(0);

            CentreStatusInfo.getOpenCentres().add(trainingHub1);
            CentreStatusInfo.getOpenCentres().add(trainingHub2);
        }

        centre.setAge(0);
        CSI.getOpenCentres().add(centre);
        //System.out.println("Centre created:  " + centre.getClass().getSimpleName());
        LoggerClass.logTrace("Centre Created of type : " + centre.getClass().getSimpleName());
        return centre;
    }

    public static void updateCentreAge() {

        for (Centres centres : CSI.getOpenCentres()) {
            centres.setAge(centres.getAge() + 1);
        }

    }

    //This Constructor is for testing purposes only
    public static Centres createCentre(int cap) {
        Centres centre = null;
        if(cap > 3){centre = Factory.centreFactory(1);}
        else
        {centre = Factory.centreFactory(cap);}
        //centre.setCentreStatus(TraineeCentre.CentreStatus.FULL);
        CSI.getOpenCentres().add(centre);
        return centre;
    }

    public static boolean isFull(Centres centre) {
        return centre.getCentreStatus() == TraineeCentre.CentreStatus.FULL;
    }

    public static boolean isTechCentre(Centres centre) {
        return centre.getClass().getSimpleName().equals("TechCentre");
    }

    public static int getTrainees() {
        int countTrainees = 0;

        for (Centres centre : CSI.getOpenCentres()) {
            countTrainees += centre.getCurrentCapacity();
        }
        CSI.setTotalNumberOfTrainees(countTrainees);
        return countTrainees;
    }

    public static int getTrainees(Courses.CourseType course) {
        int countTrainees = 0;

        for (Centres centre : CSI.getOpenCentres()) {
            for (Trainee trainee : centre.getTrainees()) {
                if (trainee.getTraineeCourse() == course) {
                    countTrainees++;
                }
            }
        }
        return countTrainees;
    }//returns number of trainees in a particular stream

    public static void addTrainees(ArrayList<Centres> openCentres) {
        if (openCentres.size() != 0) {

            for (Centres openCentre : openCentres) {

                if (!isFull(openCentre)) {
                    for (int i = 0; i < randoms.generateNumberOfTraineesForCentres(); i++) {
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
                if (isTechCentre(openCentre)) {
                    Trainee trainee = TraineeManager.getTraineeTechCentre(WaitingList.getWaitingList(),
                            openCentre.getCentreCourseType());
                    techCentreMatch(openCentre, trainee);
                } else {
                    openCentre.addTrainee(TraineeManager.getTrainee(WaitingList.getWaitingList()));
                }
            } else if (TraineeManager.getUnplacedTrainees().size() > 0) {
                openCentre.addTrainee(TraineeManager.getTrainee(TraineeManager.getUnplacedTrainees()));
            } else {
                LoggerClass.logTrace("No trainees available for placement");

            }
            openCentre.checkCentreStatus();
        }
    }

    private static void techCentreMatch(Centres openCentre, Trainee trainee) {
        if (trainee.getTraineeCourse() == openCentre.getCentreCourseType()) {
            openCentre.addTrainee(trainee);
        } else {
            TraineeManager.getUnplacedTrainees().add(trainee);
        }
    }

    public static void addUnplacedTraineesToWaitingList() {
        WaitingList.addAllTrainees(TraineeManager.getUnplacedTrainees());
        TraineeManager.emptyUnplacedTrainees();
    }

    public static void addTrainee(Centres centre, Trainee trainee) {

        if (WaitingList.getWaitingListSize() != 0) {
            WaitingList.addTraineesToCentre(centre, randoms.generateNumberOfTraineesForCentres());
        }

    }

    //this method is purely for testing purposes
    public static void destroyAllCentres() {
        CSI.getOpenCentres().clear();
    }

    public static void addCentreToOpenCentres(Centres centre) {
        CSI.getOpenCentres().add(centre);
    }

    public static ArrayList<Centres> getFreeCentres() {
        ArrayList<Centres> freeCentres = new ArrayList<>();
        for (Centres centre : CSI.getOpenCentres()) {
            if (!isFull(centre)) {
                freeCentres.add(centre);
            }
        }
        return freeCentres;
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
                CSI.getOpenCentres().get(CSI.getOpenCentres().indexOf(freeCentres.get(centreToAdd))).addTrainee(trainee);
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
}