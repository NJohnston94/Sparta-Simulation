package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.view.UserInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserInterfaceTest {

    @Test
    public void checkUserInputIsCorrect(){
        //Simple test to check if input is read correctly, will enter 10 when prompted
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertEquals(10, UserInterface.getDurationInput());
    }

    
}
