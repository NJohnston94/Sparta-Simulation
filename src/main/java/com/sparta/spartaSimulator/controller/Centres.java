package com.sparta.spartaSimulator.controller;


import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;

import java.util.HashSet;

public interface Centres {

    public TraineeCentre.CentreStatus getCentreStatus();

    void setCentreStatus (TraineeCentre.CentreStatus centreStatus);

    void checkCentreStatus();

    void setAge(int age);

    int getAge();

    void setSafePeriod(int safePeriod);

    int getSafePeriod();

    public void addTrainee(Trainee trainee);

    public void addAllTrainees(HashSet<Trainee> trainees);

    public int getCurrentCapacity();

    public int getMaxCapacity();

    public HashSet<Trainee> getTrainees();
}
