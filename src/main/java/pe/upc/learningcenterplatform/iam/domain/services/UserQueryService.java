package pe.upc.learningcenterplatform.iam.domain.services;

import pe.upc.learningcenterplatform.iam.domain.model.aggregates.User;
import pe.upc.learningcenterplatform.iam.domain.model.queries.GetAllUsersQuery;
import pe.upc.learningcenterplatform.iam.domain.model.queries.GetUserByIdQuery;
import pe.upc.learningcenterplatform.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);

}
