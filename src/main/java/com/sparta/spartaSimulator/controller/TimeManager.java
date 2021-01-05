package com.sparta.spartaSimulator.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimeManager implements Runnable {

    private static long currentTime;
    private static long counter = 0;
    private static int numberOfIterations;

    public static long getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(long currentTime) {
        TimeManager.currentTime = currentTime;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        TimeManager.numberOfIterations = numberOfIterations;
    }

    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    public static long delayTime(long separation, long iteration, long startTime) {

        long temp = (getSystemTime()-startTime);

        // Calculate delay in milliseconds
        return (separation * iteration) - temp;
    }


    @Override
    public void run() {

        long startTime = getSystemTime();
        long separation = 1000;
        long delay = 0;

        numberOfIterations = 10;

        // Need to set numberOfIterations via the value from userInterface

        // Could also set the separation here using an input from userInterface

        while (counter < numberOfIterations) {

            // Do Stuff
            System.out.println("Start of each iteration : " + (getSystemTime() - startTime));

            // Every Two months generate Centres
            if (counter % 2 == 0) {
                //CentreManager.generateCentre;
            }

            // Every month generate employees
            // Use centreManager to move trainees


            // counter++
            counter++;

            delay = delayTime(separation, counter, startTime);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted due to exception");
            }

        }
    }

}
