package com.sparta.spartaSimulator;


import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
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

        WaitingList.getWaitingList().clear();



        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        WaitingList.addTrainees(trainee1);
        WaitingList.addTrainees(trainee2);
        WaitingList.addTrainees(trainee3);

        Assertions.assertEquals(WaitingList.getWaitingListSize(),3);

    }



    @Test
    public void checkWaitingListCanMoveTrainees(){
        WaitingList.getWaitingList().clear();

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        WaitingList.addTrainees(trainee1);
        WaitingList.addTrainees(trainee2);
        WaitingList.addTrainees(trainee3);

        Centres centre = Factory.centreFactory(1);

        WaitingList.addTraineesToCentre(centre, 3);

        Assertions.assertEquals(centre.getCurrentCapacity(), 3);
        Assertions.assertEquals(WaitingList.getWaitingListSize(), 0);

    }



    @Test
    public void checkWaitingCanAddAll(){
        WaitingList.getWaitingList().clear();


        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();


        HashSet<Trainee> testSet = new HashSet<>();
        testSet.add(trainee1);
        testSet.add(trainee2);
        testSet.add(trainee3);

        WaitingList.addAllTrainees(testSet);


        Assertions.assertEquals(WaitingList.getWaitingListSize(), 3);




    }



    @Test
    public void checkCanGetWaitingList(){
        WaitingList.getWaitingList().clear();

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        WaitingList.addTrainees(trainee1);
        WaitingList.addTrainees(trainee2);
        WaitingList.addTrainees(trainee3);


        ArrayList<Trainee> testList = WaitingList.getWaitingList();

        Assertions.assertEquals(testList.size(), WaitingList.getWaitingListSize());

    }







}
