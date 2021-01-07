package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.TraineeManager;

import java.util.*;

public class Trainee {

    private TraineeStatus traineeStatus;
    private int traineeID;
    private TraineeCourse traineeCourse;

    public enum TraineeStatus{
        PLACED,
        WAITING,
        UNPLACED
    }

    public enum TraineeCourse {
        JAVA,
        CSHARP,
        DATA,
        DEVOPS,
        BUSINESS
    }

    private static final ArrayList<TraineeCourse> courses = new ArrayList<>(Arrays.asList(
            TraineeCourse.JAVA,
            TraineeCourse.CSHARP,
            TraineeCourse.DATA,
            TraineeCourse.DEVOPS,
            TraineeCourse.BUSINESS));

    private static final Random RANDOM = new Random();

    public Trainee() {
        this.traineeStatus = TraineeStatus.UNPLACED;
        this.traineeCourse = courses.get(RANDOM.nextInt(5));
    }

    //testing purposes so I could set the course type for Trainee when testing in TechCentreTests
    public Trainee(TraineeCourse course) {
        this.traineeStatus = TraineeStatus.UNPLACED;
        this.traineeCourse = course;
    }

    public TraineeCourse getTraineeCourse() {
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
}
