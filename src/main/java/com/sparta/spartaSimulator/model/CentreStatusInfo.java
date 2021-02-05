package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.CentreManager;
import com.sparta.spartaSimulator.controller.Centres;

import java.util.ArrayList;
import java.util.HashSet;

public class CentreStatusInfo {

    private static ArrayList<Centres> openCentres = new ArrayList<>();
    private static int numberOfFullCentres = 0;
    private static int totalNumberOfTrainees = 0;
    private static int numberOfDeletedCentres = 0;
    private static HashSet<Trainee> placedTrainees = new HashSet<>();

    public static ArrayList<Centres> getOpenCentres() {
        return openCentres;
    }

    public static void setOpenCentres(ArrayList<Centres> openCentres) {
        CentreStatusInfo.openCentres = openCentres;
    }

    public static int getNumberOfFullCentres() {
        numberOfFullCentres = 0;
        for (Centres centre : getOpenCentres()) {
            if (CentreManager.isFull(centre)) {
                numberOfFullCentres++;
            }
        }
        return numberOfFullCentres;
    }

    public static void setNumberOfFullCentres(int numberOfFullCentres) {
        CentreStatusInfo.numberOfFullCentres = numberOfFullCentres;
    }

    public static int getTotalNumberOfTrainees() {
        return totalNumberOfTrainees;
    }

    public static void setTotalNumberOfTrainees(int totalNumberOfTrainees) {
        CentreStatusInfo.totalNumberOfTrainees = totalNumberOfTrainees;
    }

    public static int getNumberOfDeletedCentres() {
        return numberOfDeletedCentres;
    }

    public static void setNumberOfDeletedCentres(int numberOfDeletedCentres) {
        CentreStatusInfo.numberOfDeletedCentres = numberOfDeletedCentres;
    }

    public static HashSet<Trainee> getPlacedTrainees() {
        for(Centres centre:openCentres) {
            placedTrainees.addAll(centre.getTrainees());
        }

        return placedTrainees;
    }

    public static int getNumberOfPlacedTrainees()
    {
        return placedTrainees.size();
    }

    public static int getNumberOfOpenCentres(){
        return getOpenCentres().size();
    }

    public static int getNumberOfOpenCentres(String course){
        int count = 0;
        for(Centres centre: getOpenCentres()){
            if(centre.getClass().getSimpleName().equals(course)){
                count++;
            }
        }
        return count;
    }
}
