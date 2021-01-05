package com.sparta.spartaSimulator.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public static int getNumberOfIterations(){
        System.out.println("Enter duration of simulation in months:");
        int months = 0;
        boolean validInput =false;

        while(!validInput){
            Scanner scanner = new Scanner(System.in);
            try{
                months = scanner.nextInt();
                //if wanting an upper limit: edit statement below to an OR statement with upper bound
                while(months < 1){
                    System.out.println("Enter valid number!");
                    months =scanner.nextInt();
                }
                validInput = true;

            }catch(InputMismatchException e){
                System.out.println("Enter a number!");
                validInput =false;
            }
        }

        return months;

    }

    //Additional method: setting frequency of creation of centres (only use when MVP is complete!)

    public static int getFrequencyOfCentresInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how frequent new centres should be created in months:");
        int frequency = scanner.nextInt();

        while(frequency < 1){
            System.out.println("Enter valid number:");
            frequency = scanner.nextInt();
        }

        return frequency;
    }


    /**
     * Test via reading back in the input, if there is additional time
     */

    public static void main(String[] args) {
        System.out.println("Months: " + getDurationInput());
    }










}
