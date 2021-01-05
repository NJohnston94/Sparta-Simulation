package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import java.util.HashSet;

public class TraineeManager {

    private static final int MIN_TRAINEES = 20;
    private static final int MAX_TRAINEES = 30;
    private static final int RANGE = MAX_TRAINEES-MIN_TRAINEES+1;

    public static Trainee[] createTrainees(int randomNumber){
        //done as array as size is passed through, but can be changed to what is used in other classes

        Trainee[] result = new Trainee[randomNumber];
        for(int i = 0; i < randomNumber; i++){
            result[i] = new Trainee();
        }
        return result;
    }

    public static HashSet<Trainee> createTrainees(){

        HashSet<Trainee> newTrainees = new HashSet<>();
        int randomNumber = generateRandomNumber(MIN_TRAINEES,MAX_TRAINEES);

        for(int i = 0; i < randomNumber; i++){
            newTrainees.add(new Trainee());
        }

        return newTrainees;
    }//generates between min and max inclusive new Trainees and puts them in a hashmap to be returned

    private static int generateRandomNumber(int min,int max){
        int range = (max-min)+1;
        int randomNumber = (int)(Math.random() * range) + min;
        return randomNumber;
    }
}
