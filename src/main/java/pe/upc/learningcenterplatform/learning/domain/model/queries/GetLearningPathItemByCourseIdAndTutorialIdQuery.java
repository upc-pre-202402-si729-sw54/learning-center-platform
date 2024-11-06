package pe.upc.learningcenterplatform.learning.domain.model.queries;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;

public record GetLearningPathItemByCourseIdAndTutorialIdQuery(String courseId, TutorialId tutorialId) {
    public GetLearningPathItemByCourseIdAndTutorialIdQuery {
        if (courseId == null || courseId.isBlank()) {
            throw new IllegalArgumentException("courseId cannot be null or blank");
        }
        if (tutorialId == null || tutorialId.tutorialId() == null || tutorialId.tutorialId() <= 0) {
            throw new IllegalArgumentException("tutorialId cannot be null or less than or equal to 0");
        }
    }
}
