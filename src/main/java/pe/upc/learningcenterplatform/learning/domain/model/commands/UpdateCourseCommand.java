package pe.upc.learningcenterplatform.learning.domain.model.commands;

public record UpdateCourseCommand(Long courseId, String title, String description){
    public UpdateCourseCommand {
        if (courseId == null && courseId <= 0) {
            throw new IllegalArgumentException("Course id cannot be null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title cannot be null or empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Course description cannot be null or empty");
        }
    }
}
