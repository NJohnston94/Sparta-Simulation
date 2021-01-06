package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.BootCamp;
import com.sparta.spartaSimulator.model.TechCentre;
import com.sparta.spartaSimulator.model.TrainingHub;

public class Factory {

        public static Centres centreFactory(int n)
        {
            switch(n)
            {
                case 1:
                    return new TrainingHub();

                case 2:
                    return new TechCentre();

                case 3:
                    return new BootCamp();
            }
            return null;
        }
}
