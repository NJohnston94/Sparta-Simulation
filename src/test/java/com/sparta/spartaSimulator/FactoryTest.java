package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.controller.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void factoryReturnObj()
    {
        Assertions.assertNotNull(Factory.factory(1));
        Assertions.assertNotNull(Factory.factory(2));
    }
}
