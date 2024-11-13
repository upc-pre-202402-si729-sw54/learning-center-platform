package pe.upc.learningcenterplatform.iam.interfaces.rest.transform;

import pe.upc.learningcenterplatform.iam.domain.model.commands.SignInCommand;
import pe.upc.learningcenterplatform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
