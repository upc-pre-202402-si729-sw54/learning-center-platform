package pe.upc.learningcenterplatform.learning.domain.model.queries;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

/**
 * Query to get all enrollments
 */
public record GetAllEnrollmentsQuery(AcmeStudentRecordId studentRecordId) {
    public GetAllEnrollmentsQuery {
        if (studentRecordId == null || studentRecordId.studentRecordId() == null || studentRecordId.studentRecordId().isBlank()) {
            throw new IllegalArgumentException("StudentRecordId cannot be null or empty");
        }
    }
}
