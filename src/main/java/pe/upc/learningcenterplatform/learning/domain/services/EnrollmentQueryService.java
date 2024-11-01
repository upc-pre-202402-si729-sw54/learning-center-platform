package pe.upc.learningcenterplatform.learning.domain.services;

import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Enrollment;
import pe.upc.learningcenterplatform.learning.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface EnrollmentQueryService {

    Optional<Enrollment> handle(GetEnrollmentByIdQuery query);

    List<Enrollment> handle(GetAllEnrollmentsQuery query);

    List<Enrollment> handle(GetAllEnrollmentsByAcmeStudentRecordIdQuery query);

    List<Enrollment> handle(GetAllEnrollmentsByCourseIdQuery query);

    Optional<Enrollment> handle(GetEnrollmentByAcmeStudentRecordIdAndCourseIdQuery query);
}
