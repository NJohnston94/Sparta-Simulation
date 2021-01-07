package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TrainingHub extends TraineeCentre implements Centres {

    public TrainingHub() {
        setMaxCapacity(100);
        setCentreStatus(CentreStatus.NOT_FULL);
        setSafePeriod(2);
    }

}
