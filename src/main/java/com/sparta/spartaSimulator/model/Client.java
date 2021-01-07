package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.Random;

public class Client {

    private int traineeRequirement = 15;
    private com.sparta.spartaSimulator.model.Trainee.TraineeCourse courseRequirement;
    private ClientHappiness clientHappiness;
    private ArrayList<Trainee> clientCurrentTrainees = new ArrayList<Trainee>();
    private ArrayList<ArrayList<Trainee>> previousTrainees = new ArrayList<ArrayList<Trainee>>();

    private Random randomNumber = new Random();

    public enum ClientHappiness {
        HAPPY,
        UNHAPPY
    }

    public Client() {
        this.traineeRequirement += randomNumber.nextInt(30);
        Trainee.setCentreTraineeCourse(courseRequirement);
        this.clientHappiness = ClientHappiness.UNHAPPY;
    }

    public int getTraineeRequirement() {
        return traineeRequirement;
    }

    public Trainee.TraineeCourse getCourseRequirement() {
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

    public void setClientTrainees(ArrayList<Trainee> clientTrainees) {
        this.clientCurrentTrainees = clientTrainees;
    }

    public ArrayList<ArrayList<Trainee>> getPreviousTrainees() {
        return previousTrainees;
    }

    public void addToPreviousTrainees(ArrayList<Trainee> clientCurrentTrainees) {

    }
}
