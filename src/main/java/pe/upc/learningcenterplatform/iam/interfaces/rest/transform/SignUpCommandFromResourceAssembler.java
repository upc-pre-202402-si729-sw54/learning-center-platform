package pe.upc.learningcenterplatform.iam.interfaces.rest.transform;

import pe.upc.learningcenterplatform.iam.domain.model.commands.SignUpCommand;
import pe.upc.learningcenterplatform.iam.domain.model.entities.Role;
import pe.upc.learningcenterplatform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
