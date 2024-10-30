package pe.upc.learningcenterplatform.learning.domain.model.commands;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record UpdateStudentMetricsOnTutorialCompletedCommand(AcmeStudentRecordId acmeStudentRecordId) {
    public UpdateStudentMetricsOnTutorialCompletedCommand{
        if(acmeStudentRecordId == null || acmeStudentRecordId.studentRecordId() == null || acmeStudentRecordId.studentRecordId().isBlank()){
            throw new IllegalArgumentException("studentRecordId cannot be null or empty");
        }
    }
}
