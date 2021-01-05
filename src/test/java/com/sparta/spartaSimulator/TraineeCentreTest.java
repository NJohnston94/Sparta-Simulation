package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.Bootcamp;
import com.sparta.spartaSimulator.model.TraineeCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeCentreTest {

    @Test
    void doesBootcampStatusInitialize() {
        Bootcamp bootcamp = new Bootcamp();
        Assertions.assertEquals(TraineeCentre.CentreStatus.NOT_FULL, bootcamp.getCentreStatus());
    }

    @Test
    void doesBootcampCapacityInitialise() {
        Bootcamp bootcamp = new Bootcamp();
        Assertions.assertEquals(500, bootcamp.getMaxCapacity());
    }
}
