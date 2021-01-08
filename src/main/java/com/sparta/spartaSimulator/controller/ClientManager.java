package com.sparta.spartaSimulator.controller;
import com.sparta.spartaSimulator.model.Bench;
import com.sparta.spartaSimulator.model.Client;
import com.sparta.spartaSimulator.model.Trainee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ClientManager {

    private static ArrayList<Client> clients = new ArrayList<>();
    private static Random random = new Random();

    private void createClients() {
        for(int i = 0; i < random.nextInt(10); i++) {
            Client newClient = new Client();
            clients.add(newClient);
        }
    }

    public void isClientHappy(){
        for (Client client : clients){
            int clientRequirement = client.getTraineeRequirement();
            int clientCurrentTrainees = client.getClientTrainees().size();

            if (clientCurrentTrainees < clientRequirement){
                client.setClientHappiness(Client.ClientHappiness.UNHAPPY);
            }else {
                client.setClientHappiness(Client.ClientHappiness.HAPPY);
            }
        }
    }

    public static void addTraineesToAllClients(){
        for(Client client: clients){
            if(client.getClientHappiness().equals(Client.ClientHappiness.HAPPY)) {
                addTraineesToClient(client, random.nextInt(Bench.getBenchSize()));
            }
        }
    }

    private static void addTraineesToClient(Client client, int numberOfTrainees){

        Iterator iterator = Bench.getBench().iterator();
        int count = 0;
        while(iterator.hasNext() && numberOfTrainees > 0){
            Trainee trainee = (Trainee) iterator.next();
            if(trainee.getTraineeCourse()==client.getCourseRequirement()){
                //remove from bench and add to client
                client.addToClientCurrentTrainees(Bench.getTrainee(count));
                Bench.removeTraineeFromBench(count);
                numberOfTrainees--;
                //check client happiness
                if(client.getClientTrainees().size()==client.getTraineeRequirement()){
                    client.setClientHappiness(Client.ClientHappiness.HAPPY);
                    break;
                }
            }
            count++;
        }
    }

    public static void getNewClientRequirements(){
        for (Client client : clients){
            if (client.getClientHappiness() == Client.ClientHappiness.HAPPY){
                client.setNewTraineeRequirement();
            }
        }
    }

}