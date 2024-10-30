package pe.upc.learningcenterplatform.learning.domain.exceptions;

/**
 * Exception thrown when a course is not found
 * @summary
 * This exception thrown when a course is not found in the database.
 * @see RuntimeException
 * @since 1.0
 */
public class CourseNotFoundException extends RuntimeException {

    /**
     * Constructor for the exception
     * @param courseId The course ID
     */
    public CourseNotFoundException(Long courseId) {
        super(String.format("Course with ID: %d not found.", courseId));
    }
}
