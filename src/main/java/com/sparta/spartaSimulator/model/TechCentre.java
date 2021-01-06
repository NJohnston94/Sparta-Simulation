package com.sparta.spartaSimulator.model;

public class TechCentre extends TraineeCentre {

    private static Trainee.TraineeCourse techCentreCourse;

    public TechCentre() {
        setMaxCapacity(200);
        setCentreStatus(CentreStatus.NOT_FULL);
        Trainee.setTraineeCourse(techCentreCourse);
    }

}
