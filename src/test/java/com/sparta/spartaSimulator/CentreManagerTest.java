package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class CentreManagerTest {
    @Test
    public void shouldAnswerWithTrue() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void centreCreation() {
        Assertions.assertNotNull(CentreManager.createCentre());
    }

    @Test
    public void centreIsFull()
    {
        Assertions.assertNotNull(CentreManager.createCentre(100));
        Assertions.assertTrue(CentreManager.isFull(1));
    }

    @Test
    public void deleteCentre(){
        CentreManager.createCentre();
        CentreManager.createCentre();
        CentreManager.createCentre();

        CentreManager.deleteCentre(0);

        Assertions.assertEquals(2,CentreManager.openCentres.size());
    }

    @Test
    public void relocateTrainees(){
        HashSet<Trainee> toRelocate = TraineeManager.createTrainees();

        CentreManager.createCentre(100);
        CentreManager.createCentre(99);
        CentreManager.createCentre(99);

        CentreManager.relocateTrainees(toRelocate);

    }

    @Test
    public void monthyChecks(){
        CentreManager.createCentre(100);
        CentreManager.createCentre(50);
        CentreManager.createCentre(24);

        CentreManager.monthlyCheck();
        Assertions.assertEquals(2,CentreManager.openCentres.size());
        Assertions.assertEquals(74, CentreManager.openCentres.get(1).getCurrentCapacity());



    }


}
