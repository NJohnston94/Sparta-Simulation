package com.sparta.spartaSimulator.model;

public class Trainee {
    private TraineeStatus traineeStatus;
    private int traineeID;
    private final Courses.CourseType traineeCourse;
    private int monthsInTraining = 0;

    public enum TraineeStatus {
        PLACED,
        WAITING,
        UNPLACED
    }

    public Trainee() {
        this.traineeStatus = TraineeStatus.UNPLACED;
        this.traineeCourse = Courses.setRandomCourseType();
    }

    public Trainee(Courses.CourseType course) {
        this.traineeStatus = TraineeStatus.UNPLACED;
        this.traineeCourse = course;
    }

    public Courses.CourseType getTraineeCourse() {
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