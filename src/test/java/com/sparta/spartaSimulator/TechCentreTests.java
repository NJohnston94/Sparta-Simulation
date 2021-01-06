package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.WaitingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TechCentreTests {

    @Test
    public void creationTypeCheck() {
        Centres centres = Factory.centreFactory(2);
        Assertions.assertNotNull(centres);
        Assertions.assertNotNull(centres.getCentreSpecialism());
    }

    @Test
    public void TechCentreOnlyAcceptsType()
    {
        //Due to randomisation of centres taking in Trainees, this sometimes fails, but it does work i think
        Centres centres = Factory.centreFactory(2);
        CentreManager.addCentreToOpenCentres(centres);
        Trainee trainee = new Trainee(Trainee.TraineeCourse.JAVA);
        Trainee trainee1 = new Trainee(Trainee.TraineeCourse.DATA);
        Trainee trainee2 = new Trainee(Trainee.TraineeCourse.DATA);
        Trainee trainee3 = new Trainee(Trainee.TraineeCourse.BUSINESS);
        TraineeManager.unplacedTrainees.add(trainee);
        TraineeManager.unplacedTrainees.add(trainee1);
        TraineeManager.unplacedTrainees.add(trainee2);
        TraineeManager.unplacedTrainees.add(trainee3);
        CentreManager.addTrainees(CentreManager.openCentres);
        Assertions.assertEquals(2, centres.getCurrentCapacity());
        for(Trainee train: WaitingList.waitingList)
        {
            System.out.println(train.getTraineeCourse().toString());
        }
    }
}
