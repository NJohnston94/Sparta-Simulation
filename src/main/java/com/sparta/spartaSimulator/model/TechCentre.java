package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TechCentre extends TraineeCentre implements Centres {

    public TechCentre() {
        setMaxCapacity(200);
        setCentreStatus(CentreStatus.NOT_FULL);
        Trainee.setCentreTraineeCourse(centreTraineeCourse);
        setSafePeriod(2);
        //This method now belongs only in the TraineeCentre class, needed to change from Trainee to remove reliance
        //of this class only on the interface and TraineeCentre. Think its a SOLID principle maybe... I'm so tired.
        setCentreSpecialism(CentreSpecialism.DATA);
    }
}
