package pe.upc.learningcenterplatform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * TutorialId value object
 * @summary
 * TutorialId value object
 * @param tutorialId TutorialId
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record TutorialId(Long tutorialId) {
    public TutorialId {
        if (tutorialId == null || tutorialId < 0) {
            throw new IllegalArgumentException("TutorialId must not be null or less to 0");
        }
    }
}
