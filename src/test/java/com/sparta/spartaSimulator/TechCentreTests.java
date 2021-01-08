package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.controller.TraineeManager;
import com.sparta.spartaSimulator.model.TechCentre;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TrainingCourse;
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
        Assertions.assertNotNull(TrainingCourse.setRandomCourseType());
    }
    @Test
    public void TechCentreOnlyAcceptsType()
    {
        //Due to randomisation of centres taking in Trainees, this sometimes fails, but it does work i think
        TechCentre techCentre = new TechCentre();
        techCentre.setCentreCourseType(TrainingCourse.CourseType.DATA);
        CentreManager.addCentreToOpenCentres(techCentre);
        Trainee trainee = new Trainee(TrainingCourse.CourseType.JAVA);
        Trainee trainee1 = new Trainee(TrainingCourse.CourseType.DATA);
        Trainee trainee2 = new Trainee(TrainingCourse.CourseType.DATA);
        Trainee trainee3 = new Trainee(TrainingCourse.CourseType.BUSINESS);
        TraineeManager.unplacedTrainees.add(trainee);
        TraineeManager.unplacedTrainees.add(trainee1);
        TraineeManager.unplacedTrainees.add(trainee2);
        TraineeManager.unplacedTrainees.add(trainee3);
        CentreManager.addTrainees(CentreManager.openCentres);
        for (Trainee traineeTest : techCentre.getTrainees()){
            System.out.println(traineeTest.getTraineeCourse().toString());
            Assertions.assertEquals("DATA", traineeTest.getTraineeCourse().toString());
        }
    }
    @Test
    public void addingFromWaitingList()
    {
        TechCentre techCentre = new TechCentre();
        techCentre.setCentreCourseType(TrainingCourse.CourseType.DATA);
        CentreManager.addCentreToOpenCentres(techCentre);
        Trainee trainee = new Trainee(TrainingCourse.CourseType.JAVA);
        Trainee trainee1 = new Trainee(TrainingCourse.CourseType.DATA);
        Trainee trainee2 = new Trainee(TrainingCourse.CourseType.DATA);
        Trainee trainee3 = new Trainee(TrainingCourse.CourseType.BUSINESS);

        techCentre.addTrainee(trainee);
        techCentre.addTrainee(trainee1);
        techCentre.addTrainee(trainee2);
        techCentre.addTrainee(trainee3);
        CentreManager.addTrainees(CentreManager.openCentres);
        Assertions.assertEquals(2, techCentre.getCurrentCapacity());
    }

}
