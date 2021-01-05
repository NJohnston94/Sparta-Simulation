package com.sparta.spartaSimulator.view;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;

public class UserInterface {

    public static int getUserInput(){
        int userInput = 0;

        return userInput;
    }





    /**
     * Test via reading back in the input, if there is additional time
     */

    public static void displayResults(){
//        number of open centres
        // Get number of centres in HashMap
        System.out.println("Number of open centres: "+CentreManager.openCentres.size());

//        number of full centres
        // Get number of FULL centres in HashMap
        System.out.println("Number of full centres: "+CentreManager.numberOfFullCentres);

//        number of trainees currently training
        // Loop through all centres in HashMap, counting each
        System.out.println("Number of trainees currently training: "+CentreManager.totalNumberOfTrainees);

//        number of trainees on the waiting list
        // Waiting list size
        System.out.println("Number of trainees on the waiting list: "+WaitingList.waitingList.size());

    }











}
