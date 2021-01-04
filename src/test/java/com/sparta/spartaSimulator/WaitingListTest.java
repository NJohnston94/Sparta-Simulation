package com.sparta.spartaSimulator;


import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.WaitingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WaitingListTest {


    @Test
    public void checkWaitingListSizeIsCorrect(){

        ArrayList<Trainee> waitingList = WaitingList.waitingList;

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        waitingList.add(trainee1);
        waitingList.add(trainee2);
        waitingList.add(trainee3);

        Assertions.assertEquals(waitingList.size(),3);

    }







}
