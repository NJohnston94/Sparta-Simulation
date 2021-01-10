package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.Courses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeTest {

    @Test
    void doesTraineeCreateWithUNPLACEDStatus() {
        Assertions.assertEquals(new Trainee().getTraineeStatus(), Trainee.TraineeStatus.UNPLACED);
    }

    @Test
    void doesTraineePLACEDStatusSet() {
        Trainee trainee = new Trainee();
        trainee.setTraineeStatus(Trainee.TraineeStatus.PLACED);
        Assertions.assertSame(trainee.getTraineeStatus(), Trainee.TraineeStatus.PLACED);
    }

    @Test
    void doesTraineeWAITINGStatusSet() {
        Trainee trainee = new Trainee();
        trainee.setTraineeStatus(Trainee.TraineeStatus.WAITING);
        Assertions.assertSame(trainee.getTraineeStatus(), Trainee.TraineeStatus.WAITING);
    }

    @Test
    void doesTraineeGetAssignedCourse() {
        Trainee trainee = new Trainee();
        Courses.CourseType testCourse;

        if (trainee.getTraineeCourse().equals(Courses.CourseType.JAVA)) {
            testCourse = Courses.CourseType.JAVA;
        } else if (trainee.getTraineeCourse().equals(Courses.CourseType.CSHARP)) {
            testCourse = Courses.CourseType.CSHARP;
        } else if (trainee.getTraineeCourse().equals(Courses.CourseType.DATA)) {
            testCourse = Courses.CourseType.DATA;
        } else if (trainee.getTraineeCourse().equals(Courses.CourseType.DEVOPS)) {
            testCourse = Courses.CourseType.DEVOPS;
        } else if (trainee.getTraineeCourse().equals(Courses.CourseType.BUSINESS)) {
            testCourse = Courses.CourseType.BUSINESS;
        } else {
            testCourse = null;
        }

        Assertions.assertEquals(trainee.getTraineeCourse(), testCourse);
    }
}
