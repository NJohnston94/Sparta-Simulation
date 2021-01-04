package com.sparta.spartaSimulator;


import com.sparta.spartaSimulator.controller.TimeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @org.junit.jupiter.api.Test
    public void shouldAnswerWithTrue() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    public void getSetCurrentTimeTest() {
        TimeManager.setCurrentTime(3);
        Assertions.assertEquals(3, TimeManager.getCurrentTime());
    }

    @Test
    public void delayTimeTest() {
        TimeManager.delayTime(2, 4);
        Assertions.assertEquals(8, TimeManager.getCurrentTime());
    }

}
