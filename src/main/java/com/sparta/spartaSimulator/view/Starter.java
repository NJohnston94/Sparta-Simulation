package com.sparta.spartaSimulator.view;

import com.sparta.spartaSimulator.controller.TimeManager;

public class Starter {
    public static void start() {
        LoggerClass.logTrace("Initialise Program");
        TimeManager timeManager = new TimeManager();

        Thread thread = new Thread(timeManager);

        thread.start();
    }
}
