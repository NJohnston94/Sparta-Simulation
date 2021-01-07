package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TechCentre extends TraineeCentre implements Centres {

    private Trainee.TraineeCourse centreTraineeCourse;

    public TechCentre() {
        setMaxCapacity(200);
        setCentreStatus(CentreStatus.NOT_FULL);
        Trainee.setCentreTraineeCourse(centreTraineeCourse);
        setSafePeriod(2);
    }

}
