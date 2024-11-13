package pe.upc.learningcenterplatform.iam.domain.services;

import pe.upc.learningcenterplatform.iam.domain.model.aggregates.User;
import pe.upc.learningcenterplatform.iam.domain.model.commands.SignInCommand;
import pe.upc.learningcenterplatform.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);


}
