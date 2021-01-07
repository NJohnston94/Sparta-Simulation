package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.model.BootCamp;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeCentreTest {

    @Test
    void doesBootcampStatusInitialize() {
        BootCamp bootcamp = new BootCamp();
        Assertions.assertEquals(TraineeCentre.CentreStatus.NOT_FULL, bootcamp.getCentreStatus());
    }

    @Test
    void doesBootcampCapacityInitialise() {
        BootCamp bootcamp = new BootCamp();
        Assertions.assertEquals(500, bootcamp.getMaxCapacity());
    }

    @Test
    void doCentresGetAssignedFull() {
        Centres centres = Factory.centreFactory(3);
        for (int i = 0; i < 500; i++) {
            Trainee trainee = new Trainee();
            centres.addTrainee(trainee);

            if (i == 498) {
                Assertions.assertEquals(TraineeCentre.CentreStatus.NOT_FULL, centres.getCentreStatus());
            }
        }

        Assertions.assertEquals(TraineeCentre.CentreStatus.FULL, centres.getCentreStatus());
    }
}
