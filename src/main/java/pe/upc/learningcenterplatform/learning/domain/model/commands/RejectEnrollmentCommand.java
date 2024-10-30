package pe.upc.learningcenterplatform.learning.domain.model.commands;

public record RejectEnrollmentCommand(Long enrollmentId) {
    public RejectEnrollmentCommand {
        if (enrollmentId == null || enrollmentId <= 0) {
            throw new IllegalArgumentException("Enrollment id cannot be null or less than 1");
        }
    }
}
