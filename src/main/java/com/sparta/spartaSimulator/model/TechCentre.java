package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TechCentre extends TraineeCentre implements Centres {

    private final Courses.CourseType centreCourseType;

    public TechCentre() {
        setMaxCapacity(PropertiesReader.getTechCentreMaxCapacity());
        setCentreStatus(CentreStatus.NOT_FULL);
        this.centreCourseType = Courses.setRandomCourseType();
        setSafePeriod(2);

    }

    @Override
    public Courses.CourseType getCentreCourseType() {
        return centreCourseType;
    }

    @Override
    public void addTrainee(Trainee trainee) {
        if (getCentreCourseType() == trainee.getTraineeCourse()) {
            super.addTrainee(trainee);
        }
    }

}
