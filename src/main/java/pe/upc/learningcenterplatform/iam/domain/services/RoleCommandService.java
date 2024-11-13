package pe.upc.learningcenterplatform.iam.domain.services;

import pe.upc.learningcenterplatform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
