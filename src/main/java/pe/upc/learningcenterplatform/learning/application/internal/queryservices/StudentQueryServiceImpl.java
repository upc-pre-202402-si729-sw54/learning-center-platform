package pe.upc.learningcenterplatform.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Student;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetStudentByAcmeStudentRecordIdQuery;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetStudentByProfileIdQuery;
import pe.upc.learningcenterplatform.learning.domain.services.StudentQueryService;
import pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByProfileIdQuery query) {
        return studentRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<Student> handle(GetStudentByAcmeStudentRecordIdQuery query) {
        return studentRepository.findByAcmeStudentRecordId(query.studentRecordId());
    }
}
