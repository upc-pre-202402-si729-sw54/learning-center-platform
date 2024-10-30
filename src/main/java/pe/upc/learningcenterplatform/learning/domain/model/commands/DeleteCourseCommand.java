package pe.upc.learningcenterplatform.learning.domain.model.commands;

public record DeleteCourseCommand (Long courseId) {
    public DeleteCourseCommand {
        if (courseId == null && courseId <= 0) {
            throw new IllegalArgumentException("Course id cannot be null");
        }
    }
}
