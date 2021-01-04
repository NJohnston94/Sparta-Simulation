package com.sparta.spartaSimulator.model;

public class Trainee {

    public enum TraineeStatus{
        PLACED,
        WAITING,
        UNPLACED
    }

    private TraineeStatus traineeStatus;
    private int traineeID;

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
