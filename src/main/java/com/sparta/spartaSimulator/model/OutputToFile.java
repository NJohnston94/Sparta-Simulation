package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.view.UserInterface;

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
            StringBuffer stringBuffer = UserInterface.presentDataToFile();
            String string = stringBuffer.toString();
            myWriter.write(string);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
