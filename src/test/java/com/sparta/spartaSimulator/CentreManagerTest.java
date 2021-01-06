package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        Centres centre = CentreManager.createCentre(1);
        Assertions.assertNotNull(centre);
        Assertions.assertTrue(CentreManager.isFull(centre));
    }

    @Test
    public void countingCorrectly()
    {
        Centres centre = CentreManager.createCentre();
        Trainee trainee = new Trainee();
        centre.addTrainee(trainee);
        Assertions.assertEquals(1, CentreManager.getTrainees());
        Centres centre2 = CentreManager.createCentre(1);
        Assertions.assertEquals(1, CentreManager.getNumberOfFullCentres());
    }


    @Test
    public void checkWaitingListPriority(){
        Centres centres = CentreManager.createCentre();
        Centres centres1 = CentreManager.createCentre();
        centres.setCentreStatus(TraineeCentre.CentreStatus.FULL);

        Trainee trainee = new Trainee();
        Trainee trainee1 = new Trainee();

        WaitingList.addTrainees(trainee);
        WaitingList.addTrainees(trainee1);
        final int size = WaitingList.getWaitingListSize();

        TraineeManager.createTrainees();

        CentreManager.addTrainees(CentreManager.openCentres);

        Assertions.assertNotEquals(size, WaitingList.getWaitingListSize());
        
    }
}
