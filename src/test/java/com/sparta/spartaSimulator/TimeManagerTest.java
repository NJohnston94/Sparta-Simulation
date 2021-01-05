package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.TimeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeManagerTest {

    @Test
    public void getSetCurrentTimeTest() {
        TimeManager.setCurrentTime(3);
        Assertions.assertEquals(3, TimeManager.getCurrentTime());
    }

    @Test
    public void delayTimeTest() {
        long startTime = TimeManager.getSystemTime();
        long delay = TimeManager.delayTime(2000, 4, startTime);
        Assertions.assertEquals(8000, delay);
    }
}
