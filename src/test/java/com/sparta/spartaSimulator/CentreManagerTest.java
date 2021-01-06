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

    @Test
    public void deleteCentre(){
        Centres first = CentreManager.createCentre();
        Centres second = CentreManager.createCentre();
        Centres third = CentreManager.createCentre(32);

        CentreManager.deleteCentre(second);

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
    public void monthlyChecks(){
        Centres trainingHub = Factory.centreFactory(1);
        for(int i = 0; i < 100; i++){
            trainingHub.addTrainee(new Trainee());
        }
        Centres techCentre = Factory.centreFactory(2);
        for(int i = 0; i < 50; i++){
            techCentre.addTrainee(new Trainee());
        }
        Centres third = Factory.centreFactory(2);
        for(int i = 0; i < 24; i++){
            third.addTrainee(new Trainee());
        }

        CentreManager.addCentreToOpenCentres(trainingHub);
        CentreManager.addCentreToOpenCentres(techCentre);
        CentreManager.addCentreToOpenCentres(third);

        CentreManager.monthlyCheck();
        Assertions.assertEquals(2,CentreManager.openCentres.size());
        Assertions.assertEquals(74, CentreManager.openCentres.get(1).getCurrentCapacity());

    }

    @Test
    public void monthlyChecksLeftOver(){
        Centres trainingHub = Factory.centreFactory(1);
        for(int i = 0; i < 100; i++){
            trainingHub.addTrainee(new Trainee());
        }
        Centres techCentre = Factory.centreFactory(2);
        for(int i = 0; i < 190; i++){
            techCentre.addTrainee(new Trainee());
        }
        Centres third = Factory.centreFactory(2);
        for(int i = 0; i < 24; i++){
            third.addTrainee(new Trainee());
        }

        CentreManager.addCentreToOpenCentres(trainingHub);
        CentreManager.addCentreToOpenCentres(techCentre);
        CentreManager.addCentreToOpenCentres(third);

        CentreManager.monthlyCheck();
        Assertions.assertEquals(2,CentreManager.openCentres.size());

        Assertions.assertEquals(14, WaitingList.getWaitingListSize());

    }

    @Test
    public void multipleCentresToDelete(){
        Centres trainingHub = Factory.centreFactory(1);
        for(int i = 0; i < 100; i++){
            trainingHub.addTrainee(new Trainee());
        }
        Centres techCentre = Factory.centreFactory(2);
        for(int i = 0; i < 190; i++){
            techCentre.addTrainee(new Trainee());
        }
        Centres third = Factory.centreFactory(2);
        for(int i = 0; i < 24; i++){
            third.addTrainee(new Trainee());
        }

        Centres multiple = Factory.centreFactory(3);
        for(int i = 0; i < 20;i++){
            multiple.addTrainee(new Trainee());
        }

        CentreManager.addCentreToOpenCentres(trainingHub);
        CentreManager.addCentreToOpenCentres(techCentre);
        CentreManager.addCentreToOpenCentres(third);
        CentreManager.addCentreToOpenCentres(multiple);

        CentreManager.monthlyCheck();
        Assertions.assertEquals(3,CentreManager.openCentres.size());


    }
}
