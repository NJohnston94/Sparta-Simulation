package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TrainingCourse;
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
        TrainingCourse.CourseType testCourse;

        if (trainee.getTraineeCourse().equals(TrainingCourse.CourseType.JAVA)) {
            testCourse = TrainingCourse.CourseType.JAVA;
        } else if (trainee.getTraineeCourse().equals(TrainingCourse.CourseType.CSHARP)) {
            testCourse = TrainingCourse.CourseType.CSHARP;
        } else if (trainee.getTraineeCourse().equals(TrainingCourse.CourseType.DATA)) {
            testCourse = TrainingCourse.CourseType.DATA;
        } else if (trainee.getTraineeCourse().equals(TrainingCourse.CourseType.DEVOPS)) {
            testCourse = TrainingCourse.CourseType.DEVOPS;
        } else if (trainee.getTraineeCourse().equals(TrainingCourse.CourseType.BUSINESS)) {
            testCourse = TrainingCourse.CourseType.BUSINESS;
        } else {
            testCourse = null;
        }

        Assertions.assertEquals(trainee.getTraineeCourse(), testCourse);
    }
}
