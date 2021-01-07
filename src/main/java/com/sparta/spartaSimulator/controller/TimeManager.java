package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.view.LoggerClass;
import com.sparta.spartaSimulator.view.UserInterface;

public class TimeManager implements Runnable {

    private static long currentTime;
    private static long counter = 0;
    private static int numberOfIterations;
    private static int centreOpeningFrequency = 2;

    public static long getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(long currentTime) {
        TimeManager.currentTime = currentTime;
    }

    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    public static long delayTime(long separation, long iteration, long startTime) {

        long temp = (getSystemTime() - startTime);

        // Calculate delay in milliseconds
        return (separation * iteration) - temp;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        TimeManager.numberOfIterations = numberOfIterations;
    }


    @Override
    public void run() {

        long monthlyOrEnd = UserInterface.dataPresentationTime();

        System.out.println("");
        numberOfIterations = UserInterface.getNumberOfIterations();
        //System.out.println("");
        //long separation = UserInterface.getTimeSeparation() * 1000;
        long separation = 1000;
        if (monthlyOrEnd == 1) {
            System.out.println("");
            System.out.println("Each second of the simulation corresponds to 1 month of real time. \n");
        }

        UserInterface.setCentreOpeningFrequency();


        long startTime = getSystemTime();
        long delay = 0;

        while (counter < numberOfIterations) {

            if (monthlyOrEnd == 1) {

                System.out.println("");
                System.out.println("Month : " + counter);

            }

            LoggerClass.logTrace("Start of iteration : " + (getSystemTime() - startTime));

            // Every Two months generate Centres
            if ((counter % centreOpeningFrequency == 0) && (counter != 0)) {
                //CentreManager.generateCentre;
                CentreManager.createCentre();
            }

            // Every month generate employees
            TraineeManager.createTrainees();
            // Use centreManager to move trainees
            CentreManager.addTrainees(CentreManager.openCentres);

            UserInterface.printOpenCentresAndSize();

            counter++;

            //CentreManager.updateCentreAge();

            if (monthlyOrEnd == 1) {
                //UserInterface.displayResults();
                UserInterface.presentData();
                delay = delayTime(separation, counter, startTime);

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted due to exception");
                }

            }

        }

        System.out.println("");
        //UserInterface.displayResults();
        UserInterface.presentData();
    }

    public static void setCentreOpeningFrequency(int centreOpeningFrequency) {
        TimeManager.centreOpeningFrequency = centreOpeningFrequency;
    }

    public static int getCentreFrequencyOpening() {
        return centreOpeningFrequency;
    }
}
