package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.TraineeCentre;

import java.util.HashMap;

public class CentreManager {
    public static HashMap<Integer, TraineeCentre> openCentres;
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;

    // Capacity
    // Getters &
    // Parameters
    // Calls factory to have centre object creates
    // Maintain how many centre objects
    public static CreationInt creatingFactory() {
        return Factory.factory(2);
    }

    public static boolean isFull() {
        for(TraineeCentre centre: openCentres.values()) {
            if(centre.getCentreStatus() == TraineeCentre.CentreStatus.FULL) {
                numberOfFullCentres++;
                return true;
            }
        }
        return false;
    }

}