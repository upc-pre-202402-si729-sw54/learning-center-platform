package pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Enrollment;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {
    List<Enrollment> findAllByAcmeStudentRecordId(AcmeStudentRecordId studentRecordId);

    List<Enrollment> findAllByCourseId(Long courseId);

    Optional<Enrollment> findByAcmeStudentRecordIdAndCourseId(AcmeStudentRecordId studentRecordId, Long courseId);
}
