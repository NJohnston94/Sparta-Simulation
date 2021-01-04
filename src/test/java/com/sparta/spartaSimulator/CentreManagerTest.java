package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CentreManagerTest {
    @Test
    public void shouldAnswerWithTrue() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void centreCreation() {
        Assertions.assertNotNull(CentreManager.createCentre());
    }
}
