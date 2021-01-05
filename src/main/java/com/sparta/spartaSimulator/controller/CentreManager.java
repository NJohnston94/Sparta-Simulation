package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.TraineeCentre;

import java.util.HashMap;

public class CentreManager {
    private HashMap<Integer, TraineeCentre> openCentres;

    // Capacity
    // Getters &
    // Parameters
    // Calls factory to have centre object creates
    // Maintain how many centre objects
    public static CreationInt creatingFactory()
    {
        return Factory.factory(2);
    }

    public boolean isFull()
    {
        for(TraineeCentre centre: openCentres.values())
        {
            if(centre.getCentreStatus() == TraineeCentre.CentreStatus.FULL)
            {
                return true;
            }
        }
        return false;
    }

}
