package pe.upc.learningcenterplatform.learning.domain.services;

import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetCourseByIdQuery;

import java.util.Optional;

public interface CourseQueryService {
    Optional<Course> handle(GetCourseByIdQuery query);
}
