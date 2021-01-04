package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraineeTest {

    @Test
    void doesTraineeCreateWithUNPLACEDStatus() {
        Assertions.assertEquals(new Trainee().getTraineeStatus(), Trainee.TraineeStatus.UNPLACED);
    }

    @Test
    void doesTraineePLACEDStatusSet() {
        Trainee trainee = new Trainee();
        trainee.setTraineeStatus(Trainee.TraineeStatus.PLACED);
        Assertions.assertSame(trainee.getTraineeStatus(), Trainee.TraineeStatus.PLACED);
    }

    @Test
    void doesTraineeWAITINGStatusSet() {
        Trainee trainee = new Trainee();
        trainee.setTraineeStatus(Trainee.TraineeStatus.WAITING);
        Assertions.assertSame(trainee.getTraineeStatus(), Trainee.TraineeStatus.WAITING);
    }
}
