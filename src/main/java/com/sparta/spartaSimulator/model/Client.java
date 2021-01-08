package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    private int traineeRequirement = 15;
    private TrainingCourse.CourseType courseRequirement;
    private ClientHappiness clientHappiness;
    private ArrayList<Trainee> clientCurrentTrainees = new ArrayList<Trainee>();
    private ArrayList<Trainee> previousTrainees = new ArrayList<Trainee>();

    private Random randomNumber = new Random();

    public enum ClientHappiness {
        HAPPY,
        UNHAPPY
    }

    public Client() {
        this.traineeRequirement += generateRequirements();
        this.courseRequirement = TrainingCourse.setRandomCourseType();
        this.clientHappiness = ClientHappiness.HAPPY;
    }

    public int getTraineeRequirement() {
        return traineeRequirement;
    }

    public int generateRequirements(){
        return randomNumber.nextInt(30);
    }

    public void setTraineeRequirement(){
        this.traineeRequirement = 15;
        this.traineeRequirement += generateRequirements();
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
        return clientCurrentTrainees;
    }

    public void addToClientCurrentTrainees(Trainee trainee) {
        clientCurrentTrainees.add(trainee);
    }

    public ArrayList<Trainee> getPreviousTrainees() {
        return previousTrainees;
    }

    public void addToPreviousTrainees(ArrayList<Trainee> clientCurrentTrainees) {
        previousTrainees.addAll(clientCurrentTrainees);
    }
}
