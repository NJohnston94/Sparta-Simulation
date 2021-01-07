package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    private int traineeRequirement = 15;
    private TrainingCourse.CourseType courseRequirement;
    private ClientHappiness clientHappiness;
    private ArrayList<Trainee> clientTrainees = new ArrayList<Trainee>();

    private Random randomNumber = new Random();

    public enum ClientHappiness {
        HAPPY,
        UNHAPPY
    }

    public Client() {
        this.traineeRequirement += randomNumber.nextInt(30);
        this.courseRequirement = TrainingCourse.setRandomCourseType();
        this.clientHappiness = ClientHappiness.UNHAPPY;
    }

    public int getTraineeRequirement() {
        return traineeRequirement;
    }

    public TrainingCourse.CourseType getCourseRequirement() {
        return courseRequirement;
    }

    public ClientHappiness getClientHappiness() {
        return clientHappiness;
    }

    public void setClientHappiness(ClientHappiness clientHappiness) {
        this.clientHappiness = clientHappiness;
    }

    public ArrayList<Trainee> getClientTrainees() {
        return clientTrainees;
    }

    public void setClientTrainees(ArrayList<Trainee> clientTrainees) {
        this.clientTrainees = clientTrainees;
    }
}
