package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.TimeManager;

public class App {
    public static void main(String[] args) {
        TimeManager timeManager = new TimeManager();

        Thread thread = new Thread(timeManager);

        thread.start();
    }
}
