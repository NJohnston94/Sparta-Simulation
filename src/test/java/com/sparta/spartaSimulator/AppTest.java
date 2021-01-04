package com.sparta.spartaSimulator;


import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AppTest {

    @org.junit.jupiter.api.Test
    public void shouldAnswerWithTrue() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void creationOfTrainees(){
        Trainee[] test = TraineeManager.createTrainees(10);
        Assertions.assertEquals(10, test.length);
    }
}
