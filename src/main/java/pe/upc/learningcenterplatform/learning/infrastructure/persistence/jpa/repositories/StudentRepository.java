package pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Student;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.ProfileId;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByAcmeStudentRecordId(AcmeStudentRecordId acmeStudentRecordId);

    Optional<Student> findByProfileId(ProfileId profileId);
}
