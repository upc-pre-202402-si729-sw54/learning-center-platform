package pe.upc.learningcenterplatform.learning.domain.model.queries;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record GetEnrollmentByAcmeStudentRecordIdAndCourseIdQuery(AcmeStudentRecordId studentRecordId, Long courseId) {
    public GetEnrollmentByAcmeStudentRecordIdAndCourseIdQuery{
        if (studentRecordId == null || studentRecordId.studentRecordId() == null || studentRecordId.studentRecordId().isBlank()) {
            throw new IllegalArgumentException("StudentRecordId cannot be null or empty");
        }
        if (courseId == null || courseId <= 0) {
            throw new IllegalArgumentException("CourseId cannot be null or less than or equal to zero");
        }
    }
}
