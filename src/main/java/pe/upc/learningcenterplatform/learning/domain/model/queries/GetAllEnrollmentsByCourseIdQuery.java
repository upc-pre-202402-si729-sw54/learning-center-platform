package pe.upc.learningcenterplatform.learning.domain.model.queries;

public record GetAllEnrollmentsByCourseIdQuery(String courseId) {
    public GetAllEnrollmentsByCourseIdQuery {
        if (courseId == null || courseId.isBlank()) {
            throw new IllegalArgumentException("courseId cannot be null or blank");
        }
    }
}
