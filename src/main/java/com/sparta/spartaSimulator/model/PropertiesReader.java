package com.sparta.spartaSimulator.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/main/resources/settings.properties";

    private static void createProperties() {
        try {
            properties.load(new FileReader(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long getSimulationDuration() {
        createProperties();
        return Long.parseLong(properties.getProperty("numberOfIterations"));
    }

    public static long getMonthlyOrEnd() {
        createProperties();
        return Long.parseLong(properties.getProperty("monthlyOrEnd"));
    }

    public static long getTimeSeparation() {
        createProperties();
        return Long.parseLong(properties.getProperty("timeSeparation"));
    }

    public static long getOpeningFrequency() {
        createProperties();
        return Long.parseLong(properties.getProperty("centreOpeningFrequency"));
    }

    public static long getBootcampMaxCapacity() {
        createProperties();
        return Long.parseLong(properties.getProperty("bootcampCapacity"));
    }

    public static long getTrainingHubMaxCapacity() {
        createProperties();
        return Long.parseLong(properties.getProperty("trainingHubCapacity"));
    }

    public static long getTechCentreMaxCapacity() {
        createProperties();
        return Long.parseLong(properties.getProperty("techCentreCapacity"));
    }

    public static long getMaxNumberOfBootcamps() {
        createProperties();
        return Long.parseLong(properties.getProperty("maxNumberOfBootcamps"));
    }

    public static long getMinTraineesCreated() {
        createProperties();
        return Long.parseLong(properties.getProperty("minTrainees"));
    }

    public static long getMaxTraineesCreated() {
        createProperties();
        return Long.parseLong(properties.getProperty("maxTrainees"));
    }

    public static long getMaxNumberOfTraineeToAdd() {
        createProperties();
        return Long.parseLong(properties.getProperty("traineesToAdd"));
    }


}
