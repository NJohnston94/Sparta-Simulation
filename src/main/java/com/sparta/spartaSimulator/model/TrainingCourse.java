package com.sparta.spartaSimulator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TrainingCourse {

    private static final Random RANDOM = new Random();
    private static final ArrayList<CourseType> courseTypes = new ArrayList<>(Arrays.asList(
            CourseType.JAVA,
            CourseType.CSHARP,
            CourseType.DATA,
            CourseType.DEVOPS,
            CourseType.BUSINESS));

    public enum CourseType {
        JAVA,
        CSHARP,
        DATA,
        DEVOPS,
        BUSINESS
    }

    public static CourseType setRandomCourseType() {
        return courseTypes.get(RANDOM.nextInt(5));
    }


}
