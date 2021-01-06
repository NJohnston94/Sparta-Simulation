package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.Trainee;
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
        Trainee.TraineeCourse testCourse;

        if (trainee.getTraineeCourse().equals(Trainee.TraineeCourse.JAVA)) {
            testCourse = Trainee.TraineeCourse.JAVA;
        } else if (trainee.getTraineeCourse().equals(Trainee.TraineeCourse.CSHARP)) {
            testCourse = Trainee.TraineeCourse.CSHARP;
        } else if (trainee.getTraineeCourse().equals(Trainee.TraineeCourse.DATA)) {
            testCourse = Trainee.TraineeCourse.DATA;
        } else if (trainee.getTraineeCourse().equals(Trainee.TraineeCourse.DEVOPS)) {
            testCourse = Trainee.TraineeCourse.DEVOPS;
        } else if (trainee.getTraineeCourse().equals(Trainee.TraineeCourse.BUSINESS)) {
            testCourse = Trainee.TraineeCourse.BUSINESS;
        } else {
            testCourse = null;
        }

        Assertions.assertEquals(trainee.getTraineeCourse(), testCourse);
    }
}
