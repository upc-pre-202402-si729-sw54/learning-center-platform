package pe.upc.learningcenterplatform.learning.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.EnrollmentStatus;
import pe.upc.learningcenterplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
public class Enrollment extends AuditableAbstractAggregateRoot<Enrollment> {

    @Getter
    @Embedded
    private AcmeStudentRecordId acmeStudentRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private EnrollmentStatus status;

    public Enrollment() {
        // Required by JPA
    }

    public Enrollment(AcmeStudentRecordId acmeStudentRecordId, Course course) {
        this.acmeStudentRecordId = acmeStudentRecordId;
        this.course = course;
        this.status = EnrollmentStatus.REQUESTED;
        // TODO: Initialize ProgressRecord
    }

}
