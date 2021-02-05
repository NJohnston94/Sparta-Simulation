package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.CentreStatusInfo;
import com.sparta.spartaSimulator.model.PropertiesReader;

import java.util.Random;

public class RandomGeneratorHub {

    public static int randomFactoryGen()
    {
        int count = 0;
        int range;
        for(Centres centre: CentreStatusInfo.getOpenCentres())
        {
            if(centre.getClass().getSimpleName().equals("BootCamp"))
            {
                count++;
            }
        }
        if(count >= PropertiesReader.getMaxNumberOfBootcamps())
        {
            range = (2-1)+1;
        }
        else
        {
            range = (3-1)+1;
        }
        return (int)(Math.random() * range) + 1;
    }

    public static int generateNumberOfTraineesForCentres() {
        Random random = new Random();
        int randomNumber = random.nextInt(21);
        return randomNumber;
    }

    public static int generateRandomNumber(int min,int max){
        int range = (max-min)+1;
        int randomNumber = (int)(Math.random() * range) + min;
        return randomNumber;
    }
}
