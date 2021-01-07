package com.sparta.spartaSimulator;

import com.sparta.spartaSimulator.model.OutputToFile;
import com.sparta.spartaSimulator.model.PropertiesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.File;

public class FileTests {
    private static final String OUTPUT_PATH = "src/main/resources/Output.txt";
    private static final String PROPERTIES_PATH = "src/main/resources/settings.properties";


    @Test
    public void testTXTExists() {
        File myFile = new File(OUTPUT_PATH);
        boolean TXTexists = myFile.exists();
        Assertions.assertTrue(TXTexists);
    }

    @Test
    public void testPropertiesFileExists() {
        File myFile = new File(PROPERTIES_PATH);
        boolean propertiesExists = myFile.exists();
        Assertions.assertTrue(propertiesExists);
    }

    @Test
    public void testOutputFileCleared() {
        OutputToFile.clearOutputFile();
    }

    @Test
    public void testProperties() {
        Assertions.assertTrue(0<PropertiesReader.getSimulationDuration());
        Assertions.assertTrue(0<PropertiesReader.getMonthlyOrEnd());
        Assertions.assertTrue(0<PropertiesReader.getTimeSeparation());
        Assertions.assertTrue(0<PropertiesReader.getOpeningFrequency());
        Assertions.assertTrue(0<PropertiesReader.getBootcampMaxCapacity());
        Assertions.assertTrue(0<PropertiesReader.getTrainingHubMaxCapacity());
        Assertions.assertTrue(0<PropertiesReader.getTechCentreMaxCapacity());
        Assertions.assertTrue(0<PropertiesReader.getMaxNumberOfBootcamps());
        Assertions.assertTrue(0<PropertiesReader.getMinTraineesCreated());
        Assertions.assertTrue(0<PropertiesReader.getMaxTraineesCreated());
        Assertions.assertTrue(0<PropertiesReader.getMaxNumberOfTraineeToAdd());
    }



}
