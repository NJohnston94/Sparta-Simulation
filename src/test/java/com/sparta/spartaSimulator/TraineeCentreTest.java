package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.BootCamp;
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
}
