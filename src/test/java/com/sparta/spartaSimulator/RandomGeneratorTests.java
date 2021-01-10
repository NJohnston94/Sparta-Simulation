package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.RandomGeneratorHub;
import com.sparta.spartaSimulator.model.Courses;
import com.sparta.spartaSimulator.model.TechCentre;
import com.sparta.spartaSimulator.model.TraineeCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTests {

    @Test
    public void factoryRandomMaxMin()
    {
        int test = RandomGeneratorHub.randomFactoryGen();
        Assertions.assertTrue(test <= 3 && test >=1);
    }

    @Test
    public void randomMinMaxCheck()
    {
        int test = RandomGeneratorHub.generateRandomNumber(0, 20);
        Assertions.assertTrue(test >= 0 && test <= 20);
    }

    @Test
    public void randomUnderTwentyOne()
    {
        int temp = RandomGeneratorHub.generateNumberOfTraineesForCentres();
        Assertions.assertTrue(temp < 21);
    }
}
