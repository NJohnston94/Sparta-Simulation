package com.sparta.spartaSimulator.view;

import com.sparta.spartaSimulator.controller.TimeManager;
import com.sparta.spartaSimulator.model.OutputToFile;

public class Starter {
    public static void start() {
        LoggerClass.logTrace("Initialise Program");
        OutputToFile.clearOutputFile();
        TimeManager timeManager = new TimeManager();

        Thread thread = new Thread(timeManager);

        thread.start();
    }
}
