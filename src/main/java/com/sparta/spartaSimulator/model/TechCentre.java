package com.sparta.spartaSimulator.model;

import com.sparta.spartaSimulator.controller.Centres;

public class TechCentre extends TraineeCentre implements Centres {

    private TrainingCourse.CourseType centreCourseType;

    public TechCentre() {
        setMaxCapacity(PropertiesReader.getTechCentreMaxCapacity());
        setCentreStatus(CentreStatus.NOT_FULL);
        this.centreCourseType = TrainingCourse.setRandomCourseType();
        setSafePeriod(2);

    }

    @Override
    public TrainingCourse.CourseType getCentreCourseType() {
        return centreCourseType;
    }

    public void setCentreCourseType(TrainingCourse.CourseType courseType){
        this.centreCourseType = courseType;
    }

    @Override
    public void addTrainee(Trainee trainee) {
        if (getCentreCourseType() == trainee.getTraineeCourse()) {
            super.addTrainee(trainee);
        }
    }

}
