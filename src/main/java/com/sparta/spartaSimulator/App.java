package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.TimeManager;
import com.sparta.spartaSimulator.view.LoggerClass;

public class App {
    public static void main(String[] args) {
        LoggerClass.logTrace("Initialise Program");
        TimeManager timeManager = new TimeManager();

        Thread thread = new Thread(timeManager);

        thread.start();
    }
}
