package com.sparta.spartaSimulator.controller;
import com.sparta.spartaSimulator.model.Client;
import java.util.ArrayList;
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

}