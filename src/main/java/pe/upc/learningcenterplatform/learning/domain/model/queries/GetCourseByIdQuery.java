package pe.upc.learningcenterplatform.learning.domain.model.queries;

public record GetCourseByIdQuery(Long courseId) {
    public GetCourseByIdQuery {
        if (courseId == null || courseId <= 0) {
            throw new IllegalArgumentException("courseId cannot be null or less than or equal to 0");
        }
    }
}
