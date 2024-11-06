package pe.upc.learningcenterplatform.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Enrollment;
import pe.upc.learningcenterplatform.learning.domain.model.queries.*;
import pe.upc.learningcenterplatform.learning.domain.services.EnrollmentQueryService;
import pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentQueryServiceImpl implements EnrollmentQueryService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentQueryServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Optional<Enrollment> handle(GetEnrollmentByIdQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Enrollment> handle(GetAllEnrollmentsQuery query) {
        return List.of();
    }

    @Override
    public List<Enrollment> handle(GetAllEnrollmentsByAcmeStudentRecordIdQuery query) {
        return List.of();
    }

    @Override
    public List<Enrollment> handle(GetAllEnrollmentsByCourseIdQuery query) {
        return List.of();
    }

    @Override
    public Optional<Enrollment> handle(GetEnrollmentByAcmeStudentRecordIdAndCourseIdQuery query) {
        return Optional.empty();
    }
}
