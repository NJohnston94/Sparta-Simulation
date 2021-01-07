package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.BootCamp;
import com.sparta.spartaSimulator.model.TechCentre;
import com.sparta.spartaSimulator.model.TraineeCentre;
import com.sparta.spartaSimulator.model.TrainingHub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeCentreTest {

    @Test
    void doesBootcampStatusInitialize() {
        BootCamp bootcamp = new BootCamp();
        Assertions.assertEquals(TraineeCentre.CentreStatus.NOT_FULL, bootcamp.getCentreStatus());
    }

    @Test
    void doesBootcampCapacityInitialise() {
        BootCamp bootcamp = new BootCamp();
        Assertions.assertEquals(500, bootcamp.getMaxCapacity());
    }

    @Test
    public void checkCanSetAge(){
        BootCamp bootCamp = new BootCamp();
        bootCamp.setAge(5);

        Assertions.assertEquals(5, bootCamp.getAge());

        TrainingHub trainingHub = new TrainingHub();
        trainingHub.setAge(2);

        Assertions.assertEquals(2, trainingHub.getAge());

        TechCentre techCentre = new TechCentre();
        techCentre.setAge(7);

        Assertions.assertEquals(7, techCentre.getAge());


    }

    @Test
    public void checkSafePeriodIsSet(){

        BootCamp bootCamp = new BootCamp();

        Assertions.assertEquals(3, bootCamp.getSafePeriod());


        TrainingHub trainingHub = new TrainingHub();

        Assertions.assertEquals(2, trainingHub.getSafePeriod());


        TechCentre techCentre = new TechCentre();

        Assertions.assertEquals(2, techCentre.getSafePeriod());

    }


}
