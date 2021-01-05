package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.TraineeCentre;

import java.util.HashMap;

public class CentreManager {
    public static HashMap<Integer, TraineeCentre> openCentres = new HashMap<>();
    public static int numberOfFullCentres = 0;
    public static int totalNumberOfTrainees = 0;
    static int centreCount = 0;

    
    public static TraineeCentre createCentre()
    {
        centreCount++;
        TraineeCentre centre = new TraineeCentre();
        openCentres.put((centreCount), centre);
        return centre;
    }

    public static TraineeCentre createCentre(int cap)
    {
        centreCount++;
        TraineeCentre centre = new TraineeCentre(cap);
        openCentres.put(centreCount, centre);
        return centre;
    }

    public static boolean isFull(int centreId)
    {
        if(openCentres.get(centreId).getCentreStatus() == TraineeCentre.CentreStatus.FULL)
        {
            numberOfFullCentres++;
            return true;
        }
        return false;
    }

    public static int getTrainees() {
        int countTrainees = 0;

        for (TraineeCentre centre: openCentres.values()) {
            countTrainees += centre.getCurrentCapacity();
        }
        totalNumberOfTrainees = countTrainees;
        return countTrainees;
    }


}