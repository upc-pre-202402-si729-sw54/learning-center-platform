package pe.upc.learningcenterplatform.learning.domain.model.commands;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record RequestEnrollmentCommand(AcmeStudentRecordId studentRecordId, Long courseId) {
    public RequestEnrollmentCommand {
        if (studentRecordId == null || studentRecordId.studentRecordId() == null || studentRecordId.studentRecordId().isEmpty()) {
            throw new IllegalArgumentException("Student record id cannot be null or empty");
        }
        if (courseId == null || courseId <= 0) {
            throw new IllegalArgumentException("Course id cannot be null or less than 1");
        }
    }
}
