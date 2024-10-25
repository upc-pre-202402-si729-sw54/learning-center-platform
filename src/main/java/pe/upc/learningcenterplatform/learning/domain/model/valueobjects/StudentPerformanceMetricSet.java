package pe.upc.learningcenterplatform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentPerformanceMetricSet(Integer totalCompletedCourses, Integer totalCompleteTutorials) {
    public StudentPerformanceMetricSet(){
        this(0,0);
    }

    public StudentPerformanceMetricSet {
        if (totalCompletedCourses == null || totalCompletedCourses < 0) {
            throw new IllegalArgumentException("Total completed courses cannot be null or less than 0");
        }
        if (totalCompleteTutorials == null || totalCompleteTutorials < 0) {
            throw new IllegalArgumentException("Total complete tutorials cannot be null or less than 0");
        }
    }

    public StudentPerformanceMetricSet incrementTotalCompletedCourses() {
        return new StudentPerformanceMetricSet(totalCompletedCourses + 1, totalCompleteTutorials);
    }

    public StudentPerformanceMetricSet incrementTotalCompleteTutorials() {
        return new StudentPerformanceMetricSet(totalCompletedCourses, totalCompleteTutorials + 1);
    }
}
