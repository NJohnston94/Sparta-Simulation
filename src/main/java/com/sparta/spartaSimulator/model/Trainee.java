package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.TraineeManager;

import java.util.*;

public class Trainee {
    private TraineeStatus traineeStatus;
    private int traineeID;
    private final TrainingCourse.CourseType traineeCourse;
    private int monthsInTraining = 0;

    public enum TraineeStatus {
        PLACED,
        WAITING,
        UNPLACED
    }

    private static final Random RANDOM = new Random();

    public Trainee() {
        this.traineeStatus = TraineeStatus.UNPLACED;
        this.traineeCourse = TrainingCourse.setRandomCourseType();
    }

    public Trainee(TrainingCourse.CourseType course) {
        this.traineeStatus = TraineeStatus.UNPLACED;
        this.traineeCourse = course;
    }

    public TrainingCourse.CourseType getTraineeCourse() {
        return traineeCourse;
    }

    public TraineeStatus getTraineeStatus() {
        return traineeStatus;
    }

    public void setTraineeStatus(TraineeStatus traineeStatus) {
        this.traineeStatus = traineeStatus;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public int getMonthsInTraining() {
        return monthsInTraining;
    }

    public void setMonthsInTraining(int monthsInTraining) {
        this.monthsInTraining = monthsInTraining;
    }
}