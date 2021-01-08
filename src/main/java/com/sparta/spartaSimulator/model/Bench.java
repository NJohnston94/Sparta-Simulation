package com.sparta.spartaSimulator.model;
import java.util.ArrayList;
public class Bench {

    private static ArrayList<Trainee> benchList = new ArrayList<>();

    public static ArrayList<Trainee> getBench() {
        return benchList;
    }
    public static void addTrainees(Trainee trainee){
        benchList.add(trainee);
    }
    public static void addAllTrainees(ArrayList<Trainee>  trainees){
        benchList.addAll(trainees);
    }
    public static int getBenchSize(){
        return benchList.size();
    }
//    public static int getTrainees(Trainee.TraineeCourse traineeCourse){
//        int total = 0;
//        for(Trainee trainee:benchList){
//            if(trainee.getTraineeCourse()==traineeCourse){
//                total++;
//            }
//        }
//        return total;
//    }
    public static void removeTraineeFromBench(int index){
        benchList.remove(index);
    }

    public static Trainee getTrainee(int index){
        return benchList.get(index);
    }

}