package pe.upc.learningcenterplatform.learning.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.StudentPerformanceMetricSet;
import pe.upc.learningcenterplatform.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenterplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * Student aggregate root entity
 *
 * @summary This entity represents the student aggregate root entity.
 * It contains the student record id, profile id, and performance metrics.
 * @see AcmeStudentRecordId
 * @see ProfileId
 * @see StudentPerformanceMetricSet
 * @see AuditableAbstractAggregateRoot
 * @since 1.0
 */
@Entity
public class Student extends AuditableAbstractAggregateRoot<Student> {

    @Getter
    @Embedded
    @Column(name = "acme_student_id")
    private final AcmeStudentRecordId acmeStudentRecordId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private StudentPerformanceMetricSet performanceMetricsSet;

    /**
     * Default constructor
     */
    public Student() {
        super();
        this.acmeStudentRecordId = new AcmeStudentRecordId();
        this.performanceMetricsSet = new StudentPerformanceMetricSet();
    }

    public Student(String profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Student(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    public void updateMetricsOnCourseCompletion() {
        this.performanceMetricsSet = this.performanceMetricsSet.incrementTotalCompletedCourses();
    }

    public void updateMetricsOnTutorialCompletion() {
        this.performanceMetricsSet = this.performanceMetricsSet.incrementTotalCompleteTutorials();
    }

    public String getStudentRecordId() {
        return this.acmeStudentRecordId.studentRecordId();
    }

    public String getProfileId() {
        return this.profileId.profileId();
    }

    public int getTotalCompletedCourses() {
        return this.performanceMetricsSet.totalCompletedCourses();
    }

    public int getTotalCompletedTutorials() {
        return this.performanceMetricsSet.totalCompleteTutorials();
    }
}
