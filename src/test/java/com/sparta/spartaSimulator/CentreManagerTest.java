package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.model.Trainee;
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
        CentreManager.destroyAllCentres();
        Centres centre = CentreManager.createCentre();
        Trainee trainee = new Trainee();
        centre.addTrainee(trainee);
        Assertions.assertEquals(1, CentreManager.getTrainees());
        Centres centre2 = CentreManager.createCentre(1);
        Assertions.assertEquals(1, CentreManager.getNumberOfFullCentres());
    }//testing individually works fine, not all together

    @Test
    void getTraineesStreamTestOne() {
        int count = 0;
        Centres centre = CentreManager.createCentre();
        for(int i = 0; i<20;i++){
            Trainee trainee = new Trainee();
            if(trainee.getTraineeCourse() == Trainee.TraineeCourse.JAVA ){
                count++;
            }
            centre.addTrainee(trainee);
        }
        Assertions.assertEquals(count,CentreManager.getTrainees(Trainee.TraineeCourse.JAVA));
    }

    @Test
    void getTraineesStreamTestTwo() {
        CentreManager.destroyAllCentres();
        int count2 = 0;
        Centres centre1 = CentreManager.createCentre();
        for(int i = 0; i<20;i++){
            Trainee trainee = new Trainee();
            if(trainee.getTraineeCourse() == Trainee.TraineeCourse.JAVA ){
                count2++;
            }
            centre1.addTrainee(trainee);
        }
        Centres centre2 = CentreManager.createCentre();
        for(int i = 0; i<20;i++){
            Trainee trainee = new Trainee();
            if(trainee.getTraineeCourse() == Trainee.TraineeCourse.JAVA ){
                count2++;
            }
            centre2.addTrainee(trainee);
        }
        Assertions.assertEquals(count2,CentreManager.getTrainees(Trainee.TraineeCourse.JAVA));
    }//fine individually, not all together
    public void randomChecking()
    {
        Centres bootCamp1 = CentreManager.createCentre(3);
        Centres bootCamp2 = CentreManager.createCentre(3);
        String random1 = CentreManager.createCentre().getClass().getSimpleName();
        String random2 = CentreManager.createCentre().getClass().getSimpleName();
        String random3 = CentreManager.createCentre().getClass().getSimpleName();
        String random4 = CentreManager.createCentre().getClass().getSimpleName();
        String random5 = CentreManager.createCentre().getClass().getSimpleName();
        String random6 = CentreManager.createCentre().getClass().getSimpleName();
        //Testing using console window to see if the value is random
        System.out.println(random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6);
    }
}
