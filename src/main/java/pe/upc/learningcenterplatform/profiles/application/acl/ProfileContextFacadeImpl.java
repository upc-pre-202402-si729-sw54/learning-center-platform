package pe.upc.learningcenterplatform.profiles.application.acl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.queries.GetProfileByEmailQuery;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenterplatform.profiles.domain.services.ProfileCommandService;
import pe.upc.learningcenterplatform.profiles.domain.services.ProfileQueryService;
import pe.upc.learningcenterplatform.profiles.interfaces.acl.ProfileContextFacade;

@Service
public class ProfileContextFacadeImpl implements ProfileContextFacade {

    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileContextFacadeImpl(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @Override
    public String createProfile(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
        var createProfileCommand = new CreateProfileCommand(firstName, lastName, email, street, number, city, postalCode, country);
        var profile = profileCommandService.handle(createProfileCommand);

        return profile.isEmpty() ? Strings.EMPTY : profile.get().getId();
    }

    @Override
    public String fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);

        return profile.isEmpty() ? Strings.EMPTY : profile.get().getId();
    }
}
