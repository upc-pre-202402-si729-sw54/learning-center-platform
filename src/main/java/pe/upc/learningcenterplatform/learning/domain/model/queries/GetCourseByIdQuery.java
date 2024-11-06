package pe.upc.learningcenterplatform.learning.domain.model.queries;

public record GetCourseByIdQuery(String courseId) {
    public GetCourseByIdQuery {
        if (courseId == null || courseId.isBlank()) {
            throw new IllegalArgumentException("courseId cannot be null or blank");
        }
    }
}
