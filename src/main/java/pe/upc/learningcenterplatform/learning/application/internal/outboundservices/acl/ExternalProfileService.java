package pe.upc.learningcenterplatform.learning.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenterplatform.profiles.interfaces.acl.ProfileContextFacade;

import java.util.Optional;

@Service
public class ExternalProfileService {

    private final ProfileContextFacade profileContextFacade;

    public ExternalProfileService(ProfileContextFacade profileContextFacade) {
        this.profileContextFacade = profileContextFacade;
    }

    public Optional<ProfileId> fetchProfileByEmail(String email) {
        var profileId = profileContextFacade.fetchProfileIdByEmail(email);
        return profileId.isBlank() ? Optional.empty() : Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(
            String firstName,
            String lastName,
            String email,
            String street,
            String number,
            String city,
            String postalCode,
            String country) {
        var profileId = profileContextFacade.createProfile(firstName, lastName, email, street, number, city, postalCode, country);
        return profileId.isBlank() ? Optional.empty() : Optional.of(new ProfileId(profileId));
    }
}
