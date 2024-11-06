package pe.upc.learningcenterplatform.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;
import pe.upc.learningcenterplatform.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenterplatform.learning.domain.model.commands.DeleteCourseCommand;
import pe.upc.learningcenterplatform.learning.domain.model.commands.UpdateCourseCommand;
import pe.upc.learningcenterplatform.learning.domain.services.CourseCommandService;
import pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories.CourseRepository;
import pe.upc.learningcenterplatform.profiles.application.ProfileCommandServiceImpl;

import java.util.Optional;

@Service
public class CourseCommandServiceImpl implements CourseCommandService {

    private final CourseRepository courseRepository;

    public CourseCommandServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // inherit javadoc
    @Override
    public Optional<Course> handle(CreateCourseCommand command) {

        if(courseRepository.existsByTitle(command.title()))
            throw new IllegalArgumentException("Course already exists: " + command.title());

        var course = new Course(command);
        try{
            courseRepository.save(course);
        }catch (Exception e){
            throw new IllegalArgumentException("Error saving course: %s".formatted(e.getMessage()));
        }

        return Optional.of(course);
    }

    // inherit javadoc
    @Override
    public Optional<Course> handle(UpdateCourseCommand command) {
        return Optional.empty();
    }

    // inherit javadoc
    @Override
    public void handle(DeleteCourseCommand command) {
        return;
    }
}


// ACL