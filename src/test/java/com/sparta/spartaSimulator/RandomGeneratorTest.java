package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RandomGeneratorTest {

    @Test
    public void withinBoundsRandomFactory()
    {
        int[] randomChecker = new int[15];
        int random1 = RandomGenerator.randomFactory();
        int high = 4;
        int low = 0;
        Assertions.assertTrue(random1 > low && random1 < high);
        Centres bootCamp1 = Factory.centreFactory(3);
        Centres bootCamp2 = Factory.centreFactory(3);
        CentreManager.addCentreToOpenCentres(bootCamp1);
        CentreManager.addCentreToOpenCentres(bootCamp2);
        random1 = RandomGenerator.randomFactory();
        int high2 = 3;
        int low2 = 0;
        Assertions.assertTrue(random1 > low2 && random1 < high2);
        for(int i = 0; i < randomChecker.length; i++)
        {
            randomChecker[i] = RandomGenerator.randomFactory();
        }
        System.out.println(Arrays.toString(randomChecker));
    }

    @Test
    public void withinBoundsGenerateTrainees()
    {
        int[] randomChecker = new int[15];
        int random1 = RandomGenerator.generateNumberOfTrainees();
        int high = 21;
        int low = 0;
        Assertions.assertTrue(random1 < high && random1 > low);
        random1 = RandomGenerator.generateNumberOfTrainees();
        Assertions.assertTrue(random1 < high && random1 > low);
        random1 = RandomGenerator.generateNumberOfTrainees();
        Assertions.assertTrue(random1 < high && random1 > low);
        for(int i = 0; i < randomChecker.length; i++)
        {
            randomChecker[i] = RandomGenerator.generateNumberOfTrainees();
        }
        System.out.println(Arrays.toString(randomChecker));
    }

    @Test
    public void withinBoundsGenerateRandomNumber()
    {
        int[] randomChecker = new int[15];
        int high = 21;
        int low = 0;
        int random1 = RandomGenerator.generateRandomNumber(low, high);
        Assertions.assertTrue(random1 < high && random1 > low);
        for(int i = 0; i < randomChecker.length; i++)
        {
            randomChecker[i] = RandomGenerator.generateRandomNumber(low,high);
        }
        System.out.println(Arrays.toString(randomChecker));
    }


}
