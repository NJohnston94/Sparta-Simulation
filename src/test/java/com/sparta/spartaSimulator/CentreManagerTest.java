package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        CentreManager.openCentres.clear();
        Centres centre = CentreManager.createCentre(1);
        centre.setCentreStatus(TraineeCentre.CentreStatus.FULL);
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

    }//testing individually works fine, not all together


    @Test
    public void checkCanCountFull(){

        CentreManager.destroyAllCentres();

        Centres centre2 = CentreManager.createCentre(1);
        centre2.setCentreStatus(TraineeCentre.CentreStatus.FULL);
        Assertions.assertEquals(1, CentreManager.getNumberOfFullCentres());

    }

    @Test
    void getTraineesStreamTestOne() {

        CentreManager.openCentres.clear();
        int count = 0;
        TechCentre centre = new TechCentre();
        centre.setCentreCourseType(TrainingCourse.CourseType.JAVA);
        CentreManager.addCentreToOpenCentres(centre);
        for(int i = 0; i<20;i++){
            Trainee trainee = new Trainee();
            if(trainee.getTraineeCourse() == TrainingCourse.CourseType.JAVA ){
                count++;
            }
            centre.addTrainee(trainee);
        }
        Assertions.assertEquals(count,CentreManager.getTrainees(TrainingCourse.CourseType.JAVA));
    }

    @Test
    void getTraineesStreamTestTwo() {
        CentreManager.destroyAllCentres();
        int count2 = 0;
        TechCentre centre1 = new TechCentre();
        centre1.setCentreCourseType(TrainingCourse.CourseType.JAVA);
        CentreManager.addCentreToOpenCentres(centre1);
        for(int i = 0; i<20;i++){
            Trainee trainee = new Trainee();
            if(trainee.getTraineeCourse() == TrainingCourse.CourseType.JAVA ){
                count2++;
            }
            centre1.addTrainee(trainee);
        }
        TechCentre centre2 = new TechCentre();
        centre2.setCentreCourseType(TrainingCourse.CourseType.JAVA);
        CentreManager.addCentreToOpenCentres(centre2);
        for(int i = 0; i<20;i++){
            Trainee trainee = new Trainee();
            if(trainee.getTraineeCourse() == TrainingCourse.CourseType.JAVA ){
                count2++;
            }
            centre2.addTrainee(trainee);
        }
        Assertions.assertEquals(count2,CentreManager.getTrainees(TrainingCourse.CourseType.JAVA));
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

        final int size = CentreManager.openCentres.size();


        CentreManager.deleteCentre(third);

        Assertions.assertEquals(size-1, CentreManager.openCentres.size());
    }

    @Test
    public void relocateTrainees(){
        CentreManager.openCentres.clear();

        HashSet<Trainee> toRelocate = TraineeManager.createTrainees();

        CentreManager.createCentre(100);
        CentreManager.createCentre(99);
        CentreManager.createCentre(99);

        CentreManager.relocateTrainees(toRelocate);

    }

    @Test
    public void monthlyChecks(){

        CentreManager.openCentres.clear();

        Centres trainingHub = Factory.centreFactory(1);
        for(int i = 0; i < 100; i++){
            trainingHub.addTrainee(new Trainee());
        }
        Centres techCentre = Factory.centreFactory(1);
        for(int i = 0; i < 50; i++){
            techCentre.addTrainee(new Trainee());
        }
        Centres third = Factory.centreFactory(1);
        for(int i = 0; i < 24; i++){
            third.addTrainee(new Trainee());
        }

        CentreManager.addCentreToOpenCentres(trainingHub);
        CentreManager.addCentreToOpenCentres(techCentre);
        third.setAge(3);
        CentreManager.addCentreToOpenCentres(third);


        CentreManager.monthlyCheck();
        Assertions.assertEquals(2,CentreManager.openCentres.size());
        Assertions.assertEquals(74, CentreManager.openCentres.get(1).getCurrentCapacity());

    }

    @Test
    public void monthlyChecksLeftOver(){
        CentreManager.openCentres.clear();
        WaitingList.getWaitingList().clear();


        Centres trainingHub = Factory.centreFactory(1);
        for(int i = 0; i < 100; i++){
            trainingHub.addTrainee(new Trainee());
        }
        Centres techCentre = Factory.centreFactory(1);
        for(int i = 0; i < 90; i++){
            techCentre.addTrainee(new Trainee());
        }
        Centres third = Factory.centreFactory(1);
        for(int i = 0; i < 24; i++){
            third.addTrainee(new Trainee());
        }

        CentreManager.addCentreToOpenCentres(trainingHub);
        CentreManager.addCentreToOpenCentres(techCentre);
        third.setAge(3);
        CentreManager.addCentreToOpenCentres(third);

        CentreManager.monthlyCheck();
        Assertions.assertEquals(2,CentreManager.openCentres.size());

        Assertions.assertEquals(14, WaitingList.getWaitingListSize());

    }

    @Test
    public void multipleCentresToDelete(){
        CentreManager.openCentres.clear();
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

        third.setAge(3);
        CentreManager.addCentreToOpenCentres(third);
        multiple.setAge(3);
        CentreManager.addCentreToOpenCentres(multiple);


        CentreManager.monthlyCheck();
        Assertions.assertEquals(3,CentreManager.openCentres.size());


    }


    @Test
    public void checkWaitingListPriority(){
        CentreManager.openCentres.clear();
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


    @Test
    public void doesNumberRemainBelowCapacity(){
        Centres centres = Factory.centreFactory(1);
        CentreManager.addCentreToOpenCentres(centres);
        for (int i = 0; i < 300; i++) {
            Trainee trainee = new Trainee();

            if(!CentreManager.isFull(centres)) {
                centres.addTrainee(trainee);
            }
        }

        Assertions.assertEquals(100, centres.getCurrentCapacity());
    }

    @Test
    public void checkCanSetCentreAge(){
        Centres centres = CentreManager.createCentre();

        Assertions.assertEquals(0,centres.getAge());
    }

}
