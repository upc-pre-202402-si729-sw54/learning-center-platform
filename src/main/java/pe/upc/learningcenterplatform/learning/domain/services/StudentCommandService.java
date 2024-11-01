package pe.upc.learningcenterplatform.learning.domain.services;

import pe.upc.learningcenterplatform.learning.domain.model.commands.CreateStudentCommand;
import pe.upc.learningcenterplatform.learning.domain.model.commands.UpdateStudentMetricsOnTutorialCompletedCommand;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public interface StudentCommandService {
    AcmeStudentRecordId handle(CreateStudentCommand command);

    AcmeStudentRecordId handle(UpdateStudentMetricsOnTutorialCompletedCommand command);
}
