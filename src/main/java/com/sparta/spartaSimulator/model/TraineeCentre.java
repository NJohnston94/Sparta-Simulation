package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.HashSet;

public class TraineeCentre {

    private int centreID;
    private HashSet<Trainee> allTrainees = new HashSet<>();
    private final static int MAX_CAPACITY = 100;
    private int currentCapacity;
    private int availablePlaces = MAX_CAPACITY;
    private boolean isFull;

    private static int numOfCentres = 0;

    public TraineeCentre(){
        numOfCentres++;
        centreID = numOfCentres;
    }

    public TraineeCentre(int centreID) {
        this.centreID = centreID;
    }

    public void addTrainee(Trainee trainee){
        allTrainees.add(trainee);
        currentCapacity++;
        availablePlaces--;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }



}
