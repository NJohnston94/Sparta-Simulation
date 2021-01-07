package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.CentreManager;

import java.io.FileWriter;
import java.io.IOException;

public class OutputToFile {
    private static final String OUTPUT_PATH = "src/main/resources/Output.txt";


    public static void writeDataToFile() {
        try {
            FileWriter myWriter = new FileWriter(OUTPUT_PATH, false);
            myWriter.write("End of simulation data:\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
