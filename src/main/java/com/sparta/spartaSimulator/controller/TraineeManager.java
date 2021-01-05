package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import java.util.HashSet;

public class TraineeManager {

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
        int randomNumber = (int)(Math.random() * 11) + 20;

        for(int i = 0; i < randomNumber; i++){
            newTrainees.add(new Trainee());
        }

        return newTrainees;
    }//generates between 20 and 30 new Trainees and puts them in a hashmap to be returned

}
