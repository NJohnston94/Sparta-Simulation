package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeManagerTest {

    @Test
    public void creationOfTrainees(){
        Trainee[] test = TraineeManager.createTrainees(10);
        Assertions.assertEquals(10, test.length);
    }

    @Test
    void checkLowerBound() {
        System.out.println(TraineeManager.createTrainees().size());
        Assertions.assertTrue(TraineeManager.createTrainees().size()>=20);
    }

    @Test
    void checkUpperBound() {
        Assertions.assertTrue(TraineeManager.createTrainees().size()<=30);
    }


}
