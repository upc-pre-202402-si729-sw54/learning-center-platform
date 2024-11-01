package pe.upc.learningcenterplatform.learning.domain.services;

import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;
import pe.upc.learningcenterplatform.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenterplatform.learning.domain.model.commands.DeleteCourseCommand;
import pe.upc.learningcenterplatform.learning.domain.model.commands.UpdateCourseCommand;

import java.util.Optional;

public interface CourseCommandService {
    Optional<Course> handle(CreateCourseCommand command);
    Optional<Course> handle(UpdateCourseCommand command);
    void handle(DeleteCourseCommand command);
}
