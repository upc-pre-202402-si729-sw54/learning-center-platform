package pe.upc.learningcenterplatform.learning.domain.model.commands;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;

public record CompleteTutorialForEnrollmentCommand(Long enrollmentId, TutorialId tutorialId) {
    public CompleteTutorialForEnrollmentCommand {
        if (enrollmentId == null || enrollmentId <= 0) {
            throw new IllegalArgumentException("Enrollment id cannot be null or less than 1");
        }
        if (tutorialId == null || tutorialId.tutorialId() == null || tutorialId.tutorialId() <= 0) {
            throw new IllegalArgumentException("Tutorial id cannot be null or less than 1");
        }
    }
}
