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

    public static int getBootcampMaxCapacity() {
        createProperties();
        return Integer.parseInt(properties.getProperty("bootcampCapacity"));
    }

    public static int getTrainingHubMaxCapacity() {
        createProperties();
        return Integer.parseInt(properties.getProperty("trainingHubCapacity"));
    }

    public static int getTechCentreMaxCapacity() {
        createProperties();
        return Integer.parseInt(properties.getProperty("techCentreCapacity"));
    }

    public static int getMaxNumberOfBootcamps() {
        createProperties();
        return Integer.parseInt(properties.getProperty("maxNumberOfBootcamps"));
    }

    public static int getMinTraineesCreated() {
        createProperties();
        return Integer.parseInt(properties.getProperty("minTrainees"));
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
