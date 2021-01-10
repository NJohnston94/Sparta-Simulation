package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void checkNewClientTraineeRequirement() {
        Client client = new Client();

        Assertions.assertTrue(client.getTraineeRequirement() >= 15);
        Assertions.assertTrue(client.getTraineeRequirement() <= 45);
    }

    @Test
    public void checkNewClientCourseRequirement() {
        Client client = new Client();


    }

    @Test
    public void checkNewClientHappiness() {
        Client client = new Client();

        Assertions.assertEquals("HAPPY", client.getClientHappiness().toString());
    }
}
