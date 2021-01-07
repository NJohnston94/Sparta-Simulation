package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;
import com.sparta.spartaSimulator.controller.Factory;
import com.sparta.spartaSimulator.model.BootCamp;
import com.sparta.spartaSimulator.model.Trainee;
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
    void doCentresGetAssignedFull() {
        Centres centres = Factory.centreFactory(3);
        for (int i = 0; i < 500; i++) {
            Trainee trainee = new Trainee();
            centres.addTrainee(trainee);

            if (i == 498) {
                Assertions.assertEquals(TraineeCentre.CentreStatus.NOT_FULL, centres.getCentreStatus());
            }
        }

        Assertions.assertEquals(TraineeCentre.CentreStatus.FULL, centres.getCentreStatus());
    }

    @Test
    void checkDoesNotAddIfFull(){
        Centres centres = Factory.centreFactory(1);

        centres.setCentreStatus(TraineeCentre.CentreStatus.FULL);

        Trainee trainee = new Trainee();

        centres.addTrainee(trainee);

        Assertions.assertEquals(0, centres.getCurrentCapacity());

    }
  
    @Test
    void checkCanSetAge(){
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
    void checkSafePeriodIsSet(){

        BootCamp bootCamp = new BootCamp();

        Assertions.assertEquals(3, bootCamp.getSafePeriod());


        TrainingHub trainingHub = new TrainingHub();

        Assertions.assertEquals(2, trainingHub.getSafePeriod());


        TechCentre techCentre = new TechCentre();

        Assertions.assertEquals(2, techCentre.getSafePeriod());

    }

}
