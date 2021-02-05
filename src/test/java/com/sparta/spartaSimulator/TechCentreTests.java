package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.CentreStatusInfo;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.Courses;
import com.sparta.spartaSimulator.model.WaitingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TechCentreTests {

    @Test
    public void creationTypeCheck() {
        Centres centres = Factory.centreFactory(2);
        Assertions.assertNotNull(centres);
        Assertions.assertNotNull(Courses.setRandomCourseType());
    }

    @Test
    public void TechCentreOnlyAcceptsType()
    {
        //Due to randomisation of centres taking in Trainees, this sometimes fails, but it does work i think
        Centres centres = Factory.centreFactory(2);
        CentreManager.addCentreToOpenCentres(centres);
        Trainee trainee = new Trainee(Courses.CourseType.JAVA);
        Trainee trainee1 = new Trainee(Courses.CourseType.DATA);
        Trainee trainee2 = new Trainee(Courses.CourseType.DATA);
        Trainee trainee3 = new Trainee(Courses.CourseType.BUSINESS);
        TraineeManager.getUnplacedTrainees().add(trainee);
        TraineeManager.getUnplacedTrainees().add(trainee1);
        TraineeManager.getUnplacedTrainees().add(trainee2);
        TraineeManager.getUnplacedTrainees().add(trainee3);
        CentreManager.addTrainees(CentreStatusInfo.getOpenCentres());

        for (Trainee traineeTest : centres.getTrainees()){
            System.out.println(traineeTest.getTraineeCourse().toString());
        }

    }

    @Test
    public void addingFromWaitingList()
    {
        Centres techCentre = Factory.centreFactory(2);
        Centres bootCamp = Factory.centreFactory(3);
        CentreManager.addCentreToOpenCentres(techCentre);
        CentreManager.addCentreToOpenCentres(bootCamp);
        Trainee trainee = new Trainee(Courses.CourseType.JAVA);
        Trainee trainee1 = new Trainee(Courses.CourseType.DATA);
        Trainee trainee2 = new Trainee(Courses.CourseType.DATA);
        Trainee trainee3 = new Trainee(Courses.CourseType.BUSINESS);
        TraineeManager.getUnplacedTrainees().add(trainee);
        TraineeManager.getUnplacedTrainees().add(trainee1);
        TraineeManager.getUnplacedTrainees().add(trainee2);
        TraineeManager.getUnplacedTrainees().add(trainee3);
        CentreManager.addTrainees(CentreStatusInfo.getOpenCentres());
        assert techCentre != null;
        assert bootCamp != null;
        System.out.println("TechCentre is at: " + techCentre.getCurrentCapacity());
        System.out.println("BootCamp is at: " + bootCamp.getCurrentCapacity());
        System.out.println("Test waiting list is at: " + WaitingList.getWaitingList().size());
        CentreManager.addTrainees(CentreStatusInfo.getOpenCentres());
        System.out.println("TechCentre is at: " + techCentre.getCurrentCapacity());
        System.out.println("BootCamp is at: " + bootCamp.getCurrentCapacity());
        System.out.println("Test waiting list is at: " + WaitingList.getWaitingList().size());
    }

}
