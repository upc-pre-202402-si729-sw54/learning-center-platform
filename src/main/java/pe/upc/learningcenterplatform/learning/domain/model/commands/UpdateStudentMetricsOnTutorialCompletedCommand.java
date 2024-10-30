package pe.upc.learningcenterplatform.learning.domain.model.commands;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.AcmeStudentRecordId;

/**
 * Command to update sstudent metrics on tutorial completed
 * @param acmeStudentRecordId the student record id
 *                            Cannot be null or empty
 */
public record UpdateStudentMetricsOnTutorialCompletedCommand(AcmeStudentRecordId acmeStudentRecordId) {
    /**
     * Constructor
     * @param acmeStudentRecordId the student record id
     *                            Cannot be null or empty
     * @throws IllegalArgumentException if studentRecordId is null or empty
     */
    public UpdateStudentMetricsOnTutorialCompletedCommand{
        if(acmeStudentRecordId == null || acmeStudentRecordId.studentRecordId() == null || acmeStudentRecordId.studentRecordId().isBlank()){
            throw new IllegalArgumentException("studentRecordId cannot be null or empty");
        }
    }
}
