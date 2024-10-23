package pe.upc.learningcenterplatform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the profile id
 * @summary
 * This value object is used to represent the profile id. It is and embeddable object that is used as a value object in the profile entity.
 * @param profileId The profile id. It cannot be null or empty.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record ProfileId(String profileId) {
    public ProfileId {
        if (profileId == null) {
            throw new IllegalArgumentException("Profile Id cannot be null");
        }
        if (profileId.isBlank()) {
            throw new IllegalArgumentException("Profile Id cannot be empty");
        }
    }
}
