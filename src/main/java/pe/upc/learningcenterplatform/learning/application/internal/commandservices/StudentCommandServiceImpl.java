package pe.upc.learningcenterplatform.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.learning.domain.model.commands.CreateStudentCommand;
import pe.upc.learningcenterplatform.learning.domain.model.commands.UpdateStudentMetricsOnTutorialCompletedCommand;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.upc.learningcenterplatform.learning.domain.services.StudentCommandService;
import pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories.StudentRepository;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public AcmeStudentRecordId handle(CreateStudentCommand command) {
        return null;
    }

    @Override
    public AcmeStudentRecordId handle(UpdateStudentMetricsOnTutorialCompletedCommand command) {
        return null;
    }
}
