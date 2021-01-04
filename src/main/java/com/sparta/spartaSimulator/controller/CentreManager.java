package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.TraineeCentre;

public class CentreManager {
    // Capacity
    // Getters &
    // Parameters
    // Calls factory to have centre object creates
    // Maintain how many centre objects
    // Create centres
    public static TraineeCentre createCentre() {
        TraineeCentre traineeCentre = new TraineeCentre();
        return traineeCentre;
    }
}
