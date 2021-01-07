package com.sparta.spartaSimulator.controller;
import com.sparta.spartaSimulator.model.Bench;
import com.sparta.spartaSimulator.model.Client;
import com.sparta.spartaSimulator.model.Trainee;

import java.util.ArrayList;
import java.util.Iterator;

public class ClientManager {

    private static ArrayList<Client> clients = new ArrayList<>();

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

    public static void addTraineestoAllClients(){
        for(Client client: clients){
            addTraineestoClient(client);
        }
    }

    private static void addTraineestoClient(Client client){

        Iterator iterator = Bench.getBench().iterator();
        int count = 0;
        while(iterator.hasNext()){
            Trainee trainee = (Trainee) iterator.next();
            if(trainee.getTraineeCourse()==client.getCourseRequirement()){
                //remove from bench and add to client
                client.addToClientCurrentTrainees(Bench.getTrainee(count));
                Bench.removeTraineeFromBench(count);
                //check client happiness
                if(client.getClientTrainees().size()==client.getTraineeRequirement()){
                    client.setClientHappiness(Client.ClientHappiness.HAPPY);
                    break;
                }
            }
            count++;
        }
    }

}