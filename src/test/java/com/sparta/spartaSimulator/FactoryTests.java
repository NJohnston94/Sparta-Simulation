package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTests {

    @Test
    public void factoryIsMade()
    {
        Assertions.assertNotNull(Factory.centreFactory(1));
    }

    @Test
    public void factoryTypeTest()
    {
        Assertions.assertEquals("TrainingHub", Factory.centreFactory(1).getClass().getSimpleName());
        Assertions.assertEquals("BootCamp", Factory.centreFactory(3).getClass().getSimpleName());
        Assertions.assertEquals("TechCentre", Factory.centreFactory(2).getClass().getSimpleName());
    }

    @Test
    public void capacityCheck()
    {
        Centres trainingHub = Factory.centreFactory(1);
        Centres bootCamp = Factory.centreFactory(3);
        Centres techCentre = Factory.centreFactory(2);
        Assertions.assertEquals(100, trainingHub.getMaxCapacity());
        Assertions.assertEquals(200, techCentre.getMaxCapacity());
        Assertions.assertEquals(500, bootCamp.getMaxCapacity());
    }
}
