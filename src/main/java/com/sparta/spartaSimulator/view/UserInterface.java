package com.sparta.spartaSimulator.view;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.TimeManager;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);
    private static int openingFrequency = 2;

    public static int getUserInput(){
        try {
            Scanner inputScanner = new Scanner(System.in);
            return inputScanner.nextInt();
        }catch (InputMismatchException e){
            System.out.print("Please enter a number: \n");
        }
        return getUserInput();
    }


    public static void setCentreOpeningFrequency() {
        System.out.print("How often (in months) should a new Training Centre open?  ");
        int userInput = getUserInput();
        if(userInput > 0) {
            TimeManager.setCentreOpeningFrequency(userInput);
        }else {
            System.out.println("This value must be greater than 0.");
            setCentreOpeningFrequency();
        }
    }

    public static int getCentreFrequencyOpening() {

        return openingFrequency;

    }

    public static int getNumberOfIterations() {
        System.out.println("Enter duration of simulation in months:");
        int months = 0;
        boolean validInput = false;

        while (!validInput) {
            Scanner scanner = new Scanner(System.in);
            try {
                months = scanner.nextInt();
                //if wanting an upper limit: edit statement below to an OR statement with upper bound
                while (months < 1) {
                    System.out.println("Enter valid number!");
                    months = scanner.nextInt();
                }
                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Enter a number!");
                validInput = false;
            }
        }

        return months;

    }

    //Additional method: setting frequency of creation of centres (only use when MVP is complete!)

    public static int dataPresentationTime(){
        int value = 0;

        while(value != 1 && value != 2) {
            System.out.println("Would you like to see the information monthly or only at the end of the simulation?");
            System.out.println("1: Monthly");
            System.out.println("2: End");
            value = getUserInput();

            if(value != 1 && value != 2){
                System.out.println("error: not a valid number");
                System.out.println();
            }
        }

        return value;
    }//created, not tested

    public static void presentData(){
        System.out.println("Open Centres: ");
        System.out.println("Closed Centres: ");
        System.out.println("Full Centres: ");
        System.out.println("Trainees: ");
        System.out.println("  Java: ");
        System.out.println("  C#: ");
        System.out.println("  Data: ");
        System.out.println("  DevOps: ");
        System.out.println("  Business: ");
    }//where info name included, info location has not

    /**
     * Test via reading back in the input, if there is additional time
     */


    public static void displayResults() {
//        number of open centres
        System.out.println("Number of open centres: " + CentreManager.openCentres.size());

//        number of full centres
        System.out.println("Number of full centres: " + CentreManager.numberOfFullCentres);

//        number of trainees currently training
        System.out.println("Number of trainees currently training: " + CentreManager.getTrainees());

//        number of trainees on the waiting list
        System.out.println("Number of trainees on the waiting list: " + WaitingList.getWaitingListSize());


    }


    public static long getTimeSeparation() {

        System.out.print("How long in seconds would you like one month to be during the simulator? \n" +
                "As an example, an answer of 1 would cause the simulator to run for 1 second before moving on to the second month. \n");
        int userInput = getUserInput();
        int separation = 0;
        if(userInput > 0) {
            separation = userInput;
        }else {
            System.out.println("This value must be greater than 0.");
            setCentreOpeningFrequency();
        }

        return separation;


    }


    public static void printOpenCentresAndSize() {

        for (Centres centre : CentreManager.openCentres) {
            System.out.println("Centre type : " + centre.getClass().getSimpleName() + ", Size : " + centre.getCurrentCapacity());
        }
    }




}
