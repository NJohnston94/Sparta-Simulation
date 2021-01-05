package com.sparta.spartaSimulator;


import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.WaitingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class WaitingListTest {


    @Test
    public void checkWaitingListSizeIsCorrect(){

        WaitingList waitingList = new WaitingList();

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        waitingList.addTrainees(trainee1);
        waitingList.addTrainees(trainee2);
        waitingList.addTrainees(trainee3);

        Assertions.assertEquals(waitingList.getWaitingListSize(),3);

    }



    @Test
    public void checkWaitingListCanMoveTrainees(){

        WaitingList waitingList = new WaitingList();

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        waitingList.addTrainees(trainee1);
        waitingList.addTrainees(trainee2);
        waitingList.addTrainees(trainee3);

        TraineeCentre traineeCentre = new TraineeCentre();

        waitingList.addTraineesToCentre(traineeCentre, 3);

        Assertions.assertEquals(traineeCentre.getCurrentCapacity(), 3);
        Assertions.assertEquals(waitingList.getWaitingListSize(), 0);

    }



    @Test
    public void checkWaitingCanAddAll(){
        WaitingList waitingList = new WaitingList();

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();


        HashSet<Trainee> testSet = new HashSet<>();
        testSet.add(trainee1);
        testSet.add(trainee2);
        testSet.add(trainee3);

        waitingList.addAllTrainees(testSet);


        Assertions.assertEquals(waitingList.getWaitingListSize(), 3);




    }



    @Test
    public void checkCanGetWaitingList(){

        WaitingList waitingList = new WaitingList();

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        waitingList.addTrainees(trainee1);
        waitingList.addTrainees(trainee2);
        waitingList.addTrainees(trainee3);


        ArrayList<Trainee> testList = waitingList.getWaitingList();

        Assertions.assertEquals(testList.size(), waitingList.getWaitingListSize());

    }







}
