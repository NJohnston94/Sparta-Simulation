package com.sparta.spartaSimulator.controller;

import com.sparta.spartaSimulator.model.CentreStatusInfo;
import com.sparta.spartaSimulator.model.Trainee;
import com.sparta.spartaSimulator.view.LoggerClass;

import java.util.ArrayList;
import java.util.HashSet;

public class Richard {

    private static CentreStatusInfo CSI = new CentreStatusInfo();
    //Richard
    public static void deleteCentre(Centres centre) {
        //System.out.println("DELETE CALLED with centre capacity: "+ centre.getCurrentCapacity());
        LoggerClass.logTrace("DELETE CALLED with centre capacity : " + centre.getCurrentCapacity());
        HashSet<Trainee> traineesToRelocate = centre.getTrainees();
        CSI.getOpenCentres().remove(centre);


        CentreManager.relocateTrainees(traineesToRelocate);
    }

    //Richard
    public static void monthlyCheck() {
        ArrayList<Centres> toDelete = getCentresToDelete();

        for(Centres centre : toDelete){
            deleteCentre(centre);
            int temp = CSI.getNumberOfDeletedCentres();
            CSI.setNumberOfDeletedCentres(temp + 1);
            toDelete = getCentresToDelete();
            if(toDelete.size() == 0){
                break;
            }

        }
    }

    public static ArrayList<Centres> getCentresToDelete(){

        ArrayList<Centres> toDelete = new ArrayList<>();

        for(Centres centre : CSI.getOpenCentres()) {
            boolean canDelete = centre.getSafePeriod() < centre.getAge();
            //System.out.println("OPEN CENTRES : " + centre.getCurrentCapacity());
            if (centre.getCurrentCapacity() < 25 && canDelete) {
                //and not in safe period!
                toDelete.add(centre);
            }

        }
        return toDelete;
    }
}
