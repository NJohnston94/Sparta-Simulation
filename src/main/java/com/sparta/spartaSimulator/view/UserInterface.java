package com.sparta.spartaSimulator.view;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.ClientManager;
import com.sparta.spartaSimulator.controller.TimeManager;
import com.sparta.spartaSimulator.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);
    private static int openingFrequency = PropertiesReader.getOpeningFrequency();
    private static CentreStatusInfo CSI = new CentreStatusInfo();

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
        System.out.print("How often (in months) should a new Training Centre open?  \n");
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
                    System.out.println("Please enter a valid number!");
                    months = scanner.nextInt();
                }
                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
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
        System.out.println("Open Centres: " + CSI.getNumberOfOpenCentres());
//        System.out.println("  Tech Centres: " + CentreManager.getNumberOfOpenCentres("TechCentre"));
//        System.out.println("  Bootcamp: " + CentreManager.getNumberOfOpenCentres("BootCamp"));
//        System.out.println("  Training Hub: " + CentreManager.getNumberOfOpenCentres("TrainingHub"));
        System.out.println();
        System.out.println("Closed Centres: " + CSI.getNumberOfDeletedCentres());
        System.out.println();
        System.out.println("Full Centres: " + CSI.getNumberOfFullCentres());
        System.out.println();
        System.out.println("Open Centres: " + CSI.getNumberOfOpenCentres());
        System.out.println("  Tech Centres: " + CSI.getNumberOfOpenCentres("TechCentre"));
        System.out.println("  Bootcamp: " + CSI.getNumberOfOpenCentres("BootCamp"));
        System.out.println("  Training Hub: " + CSI.getNumberOfOpenCentres("TrainingHub"));
        System.out.println();
        System.out.println("Trainees in Training: " + CSI.getNumberOfPlacedTrainees());
        System.out.println("  Java: " + CentreManager.getTrainees(Courses.CourseType.JAVA));
        System.out.println("  C#: " + CentreManager.getTrainees(Courses.CourseType.CSHARP));
        System.out.println("  Data: " + CentreManager.getTrainees(Courses.CourseType.DATA));
        System.out.println("  DevOps: " + CentreManager.getTrainees(Courses.CourseType.DEVOPS));
        System.out.println("  Business: " + CentreManager.getTrainees(Courses.CourseType.BUSINESS));
        System.out.println();
        System.out.println("Waiting List: " + WaitingList.getWaitingListSize());
        System.out.println("  Java: " + WaitingList.getTrainees(Courses.CourseType.JAVA));
        System.out.println("  C#: " + WaitingList.getTrainees(Courses.CourseType.CSHARP));
        System.out.println("  Data: " + WaitingList.getTrainees(Courses.CourseType.DATA));
        System.out.println("  DevOps: " + WaitingList.getTrainees(Courses.CourseType.DEVOPS));
        System.out.println("  Business: " + WaitingList.getTrainees(Courses.CourseType.BUSINESS));
        System.out.println();
        System.out.println();
        System.out.println("Clients: " + ClientManager.getClients().size());
        System.out.println("  Happy: " + ClientManager.getHappyClients());
        System.out.println("  Unhappy: " + ClientManager.getUnhappyClients());
        System.out.println();
        System.out.println("Trainees with Clients: " + ClientManager.getTraineesWithClient());
        System.out.println("  Java: " + ClientManager.getTrainees(Courses.CourseType.JAVA));
        System.out.println("  C#: " + ClientManager.getTrainees(Courses.CourseType.CSHARP));
        System.out.println("  Data: " + ClientManager.getTrainees(Courses.CourseType.DATA));
        System.out.println("  DevOps: " + ClientManager.getTrainees(Courses.CourseType.DEVOPS));
        System.out.println("  Business: " + ClientManager.getTrainees(Courses.CourseType.BUSINESS));
        System.out.println();
        System.out.println("Bench List: " + Bench.getBenchSize());
        System.out.println("  Java: " + Bench.getTrainees(Courses.CourseType.JAVA));
        System.out.println("  C#: " + Bench.getTrainees(Courses.CourseType.CSHARP));
        System.out.println("  Data: " + Bench.getTrainees(Courses.CourseType.DATA));
        System.out.println("  DevOps: " + Bench.getTrainees(Courses.CourseType.DEVOPS));
        System.out.println("  Business: " + Bench.getTrainees(Courses.CourseType.BUSINESS));
    }//where info name included, info location has not


    public static StringBuffer presentDataToFile(){
        StringBuffer information = new StringBuffer();
        information.append("Month:   ");
        information.append(TimeManager.getCounter());
        information.append("\n\n");

        information.append("Open Centres: ");
        information.append(CSI.getNumberOfOpenCentres());
        information.append("\n\n");

        information.append("Closed Centres: ");
        information.append(CSI.getNumberOfDeletedCentres());
        information.append("\n\n");

        information.append("Full Centres: ");
        information.append(CSI.getNumberOfFullCentres());
        information.append("\n\n");

        information.append("Open Centres: ");
        information.append(CSI.getNumberOfOpenCentres());
        information.append("\n");
        information.append("  Tech Centres: ");
        information.append(CSI.getNumberOfOpenCentres("TechCentre"));
        information.append("\n");
        information.append("  Bootcamp: ");
        information.append(CSI.getNumberOfOpenCentres("BootCamp"));
        information.append("\n");
        information.append("  Training Hub: ");
        information.append(CSI.getNumberOfOpenCentres("TrainingHub"));
        information.append("\n\n");

        information.append("Trainees in Training: ");
        information.append(CentreManager.getTrainees());
        information.append("\n");
        information.append("  Java: ");
        information.append(CentreManager.getTrainees(Courses.CourseType.JAVA));
        information.append("\n");
        information.append("  C#: ");
        information.append(CentreManager.getTrainees(Courses.CourseType.CSHARP));
        information.append("\n");
        information.append("  Data: ");
        information.append(CentreManager.getTrainees(Courses.CourseType.DATA));
        information.append("\n");
        information.append("  DevOps: ");
        information.append(CentreManager.getTrainees(Courses.CourseType.DEVOPS));
        information.append("\n");
        information.append("  Business: ");
        information.append(CentreManager.getTrainees(Courses.CourseType.BUSINESS));
        information.append("\n\n");

        information.append("Waiting List: ");
        information.append(WaitingList.getWaitingListSize());
        information.append("\n");
        information.append("  Java: ");
        information.append(WaitingList.getTrainees(Courses.CourseType.JAVA));
        information.append("\n");
        information.append("  C#: ");
        information.append(WaitingList.getTrainees(Courses.CourseType.CSHARP));
        information.append("\n");
        information.append("  Data: ");
        information.append(WaitingList.getTrainees(Courses.CourseType.DATA));
        information.append("\n");
        information.append("  DevOps: ");
        information.append(WaitingList.getTrainees(Courses.CourseType.DEVOPS));
        information.append("\n");
        information.append("  Business: ");
        information.append(WaitingList.getTrainees(Courses.CourseType.BUSINESS));
        information.append("\n\n");

        information.append("Clients: ");
        information.append(ClientManager.getClients().size());
        information.append("\n");
        information.append("  Happy: ");
        information.append(ClientManager.getHappyClients());
        information.append("\n");
        information.append("  Unhappy: ");
        information.append(ClientManager.getUnhappyClients());
        information.append("\n\n");

        information.append("Trainees with Clients: ");
        information.append(ClientManager.getTraineesWithClient());
        information.append("\n");

        information.append("  Java: ");
        information.append(ClientManager.getTrainees(Courses.CourseType.JAVA));
        information.append("\n");
        information.append("  C#: ");
        information.append(ClientManager.getTrainees(Courses.CourseType.CSHARP));
        information.append("\n");
        information.append("  Data: ");
        information.append(ClientManager.getTrainees(Courses.CourseType.DATA));
        information.append("\n");
        information.append("  DevOps: ");
        information.append(ClientManager.getTrainees(Courses.CourseType.DEVOPS));
        information.append("\n");
        information.append("  Business: ");
        information.append(ClientManager.getTrainees(Courses.CourseType.BUSINESS));
        information.append("\n\n");

        information.append("Bench List: ");
        information.append(Bench.getBenchSize());
        information.append("\n");

        information.append("  Java: ");
        information.append(Bench.getTrainees(Courses.CourseType.JAVA));
        information.append("\n");
        information.append("  C#: ");
        information.append(Bench.getTrainees(Courses.CourseType.CSHARP));
        information.append("\n");
        information.append("  Data: ");
        information.append(Bench.getTrainees(Courses.CourseType.DATA));
        information.append("\n");
        information.append("  DevOps: ");
        information.append(Bench.getTrainees(Courses.CourseType.DEVOPS));
        information.append("\n");
        information.append("  Business: ");
        information.append(Bench.getTrainees(Courses.CourseType.BUSINESS));
        information.append("\n");

        information.append("-----------------------------------");
        information.append("\n\n");

        return information;
    }

    /**
     * Test via reading back in the input, if there is additional time
     */


    public static void displayResults() {
//        number of open centres
        System.out.println("Number of open centres: " + CSI.getOpenCentres().size());

//        number of full centres
        System.out.println("Number of full centres: " + (CSI.getOpenCentres().size() - CentreManager.getFreeCentres().size()));

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

        for (Centres centre : CSI.getOpenCentres()) {
            //System.out.println("Centre type : " + centre.getClass().getSimpleName() + ", Size : " + centre.getCurrentCapacity());
            LoggerClass.logTrace("Centre type : " + centre.getClass().getSimpleName() + ", Size : " + centre.getCurrentCapacity());
        }
    }




}
