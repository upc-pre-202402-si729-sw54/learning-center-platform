package pe.upc.learningcenterplatform.learning.domain.model.queries;

import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.ProfileId;

public record GetStudentByProfileIdQuery(ProfileId profileId) {
    public GetStudentByProfileIdQuery {
        if (profileId == null || profileId.profileId() == null || profileId.profileId().isBlank()) {
            throw new IllegalArgumentException("ProfileId cannot be null or empty");
        }
    }
}
