package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;

import java.util.ArrayList;

public class TraineeManager {

    public static Trainee[] createTrainees(int randomNumber){
        //done as array as size is passed through, but can be changed to what is used in other classes

        Trainee[] result = new Trainee[randomNumber];
        for(int i = 0; i < randomNumber; i++){
            result[i] = new Trainee();
        }

        return result;
    }


}
