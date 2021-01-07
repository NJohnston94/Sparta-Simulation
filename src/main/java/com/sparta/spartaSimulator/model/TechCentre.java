package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TechCentre extends TraineeCentre implements Centres {

    private final TrainingCourse.CourseType centreCourseType;

    public TechCentre() {
        setMaxCapacity(200);
        setCentreStatus(CentreStatus.NOT_FULL);
        this.centreCourseType = TrainingCourse.setRandomCourseType();

        setSafePeriod(2);
        //This method now belongs only in the TraineeCentre class, needed to change from Trainee to remove reliance
        //of this class only on the interface and TraineeCentre. Think its a SOLID principle maybe... I'm so tired.
        //setCentreSpecialism(CentreSpecialism.DATA);
       
    }

    public TrainingCourse.CourseType getCentreCourseType() {
        return centreCourseType;
    }

        
  

}
