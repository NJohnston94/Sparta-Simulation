package com.sparta.spartaSimulator.model;

public class Trainee {

    private TraineeStatus traineeStatus;
    private int traineeID;

    public enum TraineeStatus{
        PLACED,
        WAITING,
        UNPLACED
    }

    public Trainee() {
        this.traineeStatus = TraineeStatus.UNPLACED;
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
