package com.sparta.spartaSimulator.controller;

import java.util.Random;

public class RandomGenerator {

    //Centre Manager used by create Centre
    public static int randomFactory()
    {
        int count = 0;
        int range;
        for(Centres centre: CentreManager.openCentres)
        {
            if(centre.getClass().getSimpleName().equals("BootCamp"))
            {
                count++;
            }
        }
        if(count > 1)
        { range = (2-1)+1; }
        else
        { range = (3-1)+1; }
        return (int)(Math.random() * range) + 1;
    }

    //Used in CentreManager addTrainees
    public static int generateNumberOfTrainees() {
        Random random = new Random();
        int randomNumber = random.nextInt(21);
        return randomNumber;
    }

    //Trainee Manager
    public static int generateRandomNumber(int min,int max){
        int range = (max-min)+1;
        int randomNumber = (int)(Math.random() * range) + min;
        return randomNumber;
    }
}
