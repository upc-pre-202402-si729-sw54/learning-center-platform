package pe.upc.learningcenterplatform.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetCourseByIdQuery;
import pe.upc.learningcenterplatform.learning.domain.services.CourseQueryService;
import pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories.CourseRepository;

import java.util.Optional;

@Service
public class CourseQueryServiceImpl implements CourseQueryService {

    private final CourseRepository courseRepository;

    public CourseQueryServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> handle(GetCourseByIdQuery query) {
        return Optional.empty();
    }
}
