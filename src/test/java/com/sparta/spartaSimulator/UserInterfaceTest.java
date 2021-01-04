package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.view.UserInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInterfaceTest {

    @Test
    public void checkUserInputIsCorrect(){

        Assertions.assertEquals(50,UserInterface.getUserInput());

    }

    
}
