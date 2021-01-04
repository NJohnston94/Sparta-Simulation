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
}
