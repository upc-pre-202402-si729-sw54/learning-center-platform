package pe.upc.learningcenterplatform.learning.domain.model.queries;

public record GetEnrollmentByIdQuery(Long enrollmentId) {
    public GetEnrollmentByIdQuery {
        if (enrollmentId == null) {
            throw new IllegalArgumentException("EnrollmentId cannot be null");
        }
    }
}
