package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class BootCamp extends TraineeCentre implements Centres {

    public BootCamp() {
        setCentreStatus(CentreStatus.NOT_FULL);
        setMaxCapacity(500);
    }

}
