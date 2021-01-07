package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.CentreManager;

import java.io.FileWriter;
import java.io.IOException;

public class OutputToFile {
    private static final String OUTPUT_PATH = "src/main/resources/Output.txt";

    public static void clearOutputFile() {
        try {
            FileWriter myWriter = new FileWriter(OUTPUT_PATH, false);
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void appendDataToFile() {
        try {
            FileWriter myWriter = new FileWriter(OUTPUT_PATH, true);
            myWriter.write("End of simulation data:\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
