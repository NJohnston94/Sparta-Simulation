package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Bench;
import com.sparta.spartaSimulator.model.Client;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.Courses;

import java.util.ArrayList;
import java.util.Random;

public class ClientManager {

    private static ArrayList<Client> clients = new ArrayList<>();
    private static Random random = new Random();

    public static void createClients() {
        for (int i = 0; i < random.nextInt(10); i++) {
            Client newClient = new Client();
            clients.add(newClient);
        }
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static int getHappyClients() {
        int happyClients = 0;
        for (Client client : getClients()) {
            if (client.getClientHappiness() == Client.ClientHappiness.HAPPY) {
                happyClients++;
            }
        }

        return happyClients;
    }

    public static int getUnhappyClients() {
        int unhappyClients = 0;
        for (Client client : getClients()) {
            if (client.getClientHappiness() == Client.ClientHappiness.UNHAPPY) {
                unhappyClients++;
            }
        }

        return unhappyClients;
    }

    public static void isClientHappy(Client client) {
        int clientRequirement = client.getTraineeRequirement();
        int clientCurrentTrainees = client.getClientTrainees().size();

        if (clientCurrentTrainees < clientRequirement) {
            client.setClientHappiness(Client.ClientHappiness.UNHAPPY);
        } else {
            client.setClientHappiness(Client.ClientHappiness.HAPPY);
        }
    }

    public static void addTraineesToAllClients() {
        for (Client client : clients) {
            if (client.getClientHappiness().equals(Client.ClientHappiness.HAPPY) && Bench.getBenchSize() > 0) {
                addTraineesToClient(client, random.nextInt(Bench.getBenchSize()));
            }
            if (client.getAge() % 12 == 0 && client.getAge() >= 12) {
                isClientHappy(client);
            }
        }
    }

//    private static void addTraineesToClient(Client client, int numberOfTrainees){
//
//        Iterator iterator = Bench.getBench().iterator();
//        ArrayList<Trainee> bench = Bench.getBench();
//        ArrayList<Integer> traineesToRemoveFromBench = new ArrayList<>();
//        int count = 0;
//        while(iterator.hasNext() && numberOfTrainees > 0){
//            //Trainee trainee = (Trainee) iterator.next();
//            for(Trainee trainee:bench) {
//                if(trainee.getTraineeCourse()==client.getCourseRequirement()){
//                    //remove from bench and add to client
//                    client.addToClientCurrentTrainees(Bench.getTrainee(count));
//                    traineesToRemoveFromBench.add(count);
//                    numberOfTrainees--;
//                    //check client happiness
//                    if(client.getClientTrainees().size()==client.getTraineeRequirement()){
//                        client.setClientHappiness(Client.ClientHappiness.HAPPY);
//                        break;
//                    }
//                }
//                count++;
//            }
//
//        }
//
//        for(Integer counter:traineesToRemoveFromBench) {
//            Bench.removeTraineeFromBench(counter);
//        }
//
//    }

    public static void addTraineesToClient(Client client, int numberOfTrainees) {
        ArrayList<Trainee> traineesToRemoveFromBench = new ArrayList<>();

        for (int i = 0; i < numberOfTrainees; i++) {
            client.addToClientCurrentTrainees(Bench.getTrainee(i));
            traineesToRemoveFromBench.add(Bench.getTrainee(i));
        }

        Bench.getBench().removeAll(traineesToRemoveFromBench);
    }

    public static void getNewClientRequirements() {
        for (Client client : clients) {
            if (client.getClientHappiness() == Client.ClientHappiness.HAPPY) {
                client.setNewTraineeRequirement();
            }
        }
    }

    public static void updateClientAge() {
        for (Client client : clients) {
            client.setAge(client.getAge() + 1);
        }
    }


    public static void checkClientAge() {
        for (Client client : clients) {
            if (client.getAge() % 12 == 0 && client.getClientHappiness() == Client.ClientHappiness.HAPPY) {
                getNewClientRequirements();
            }
        }
    }

    public static int getTraineesWithClient() {
        int traineesWithClients = 0;
        for (Client client : getClients()) {
            traineesWithClients += client.getClientTrainees().size();
        }

        return traineesWithClients;
    }

    public static int getTrainees(Courses.CourseType courseType) {
        int countTrainees = 0;

        for (Client client : getClients()) {
            for (Trainee trainee : client.getClientTrainees()) {
                if (trainee.getTraineeCourse() == courseType) {
                    countTrainees++;
                }
            }
        }
        return countTrainees;
    }

}