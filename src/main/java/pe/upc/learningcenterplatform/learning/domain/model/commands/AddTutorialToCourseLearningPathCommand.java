package pe.upc.learningcenterplatform.learning.domain.model.commands;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;

public record AddTutorialToCourseLearningPathCommand(TutorialId tutorialId, Long courseId) {

    public AddTutorialToCourseLearningPathCommand {
        if (tutorialId == null || tutorialId.tutorialId() <= 0) {
            throw new IllegalArgumentException("tutorial id cannot be null or empty");
        }
        if (courseId == null || courseId <= 0) {
            throw new IllegalArgumentException("Course id cannot be null or empty");
        }
    }

}
