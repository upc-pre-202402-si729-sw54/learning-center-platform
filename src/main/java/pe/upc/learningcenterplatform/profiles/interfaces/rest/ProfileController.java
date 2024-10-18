package pe.upc.learningcenterplatform.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenterplatform.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenterplatform.profiles.domain.model.queries.GetProfileByIdQuery;
import pe.upc.learningcenterplatform.profiles.domain.services.ProfileCommandService;
import pe.upc.learningcenterplatform.profiles.domain.services.ProfileQueryService;
import pe.upc.learningcenterplatform.profiles.interfaces.rest.resources.CreateProfileResource;
import pe.upc.learningcenterplatform.profiles.interfaces.rest.resources.ProfileResource;
import pe.upc.learningcenterplatform.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import pe.upc.learningcenterplatform.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;

import java.security.PublicKey;

/**
 * ProfileController class
 * <p>
 *     This class is the entry point for all the REST endpoints related to the Profile entity.
 * </p>
 */
@RestController
@RequestMapping(value="/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "profiles", description = "Profile Management Endpoints")
public class ProfileController {

    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    public ProfileController(ProfileQueryService profileQueryService, ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resrouce) {
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resrouce);
        var profile = profileCommandService.handle(createProfileCommand);

        if(profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());

        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable String profileId){
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);

        if(profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());

        return ResponseEntity.ok(profileResource);
    }

}
