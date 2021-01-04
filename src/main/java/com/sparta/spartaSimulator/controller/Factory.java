package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.model.TraineeCentre;

public class Factory {

    public static CreationInt factory(int n)
    {
        switch (n)
        {
            case 1:
                return new Trainee();

            case 2:
                return new TraineeCentre();
        }
        return null;
    }
}
