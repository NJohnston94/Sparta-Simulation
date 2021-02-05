package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.ClientManager;
import com.sparta.spartaSimulator.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientManagerTest {

    @Test
    public void creationTest()
    {
        int temp = 0;
        ClientManager.createClients();
        ArrayList<Client> clients = ClientManager.getClients();
        for(Client client: clients)
        {
            temp++;
        }
        Assertions.assertTrue(temp > 0);
    }

    @Test
    public void gettingHappyClients()
    {
        ClientManager.createClients();
        int temp = ClientManager.getHappyClients();
        Assertions.assertTrue(temp > 0);
    }

    @Test
    public void gettingUnhappyClients()
    {
        ClientManager.createClients();
        Assertions.assertEquals(0, ClientManager.getUnhappyClients());
    }
}
