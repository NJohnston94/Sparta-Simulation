package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TechCentre extends TraineeCentre implements Centres {

    private final TrainingCourse.CourseType centreCourseType;

    public TechCentre() {
        setMaxCapacity(200);
        setCentreStatus(CentreStatus.NOT_FULL);
        this.centreCourseType = TrainingCourse.setRandomCourseType();
    }

    public TrainingCourse.CourseType getCentreCourseType() {
        return centreCourseType;
    }
}
