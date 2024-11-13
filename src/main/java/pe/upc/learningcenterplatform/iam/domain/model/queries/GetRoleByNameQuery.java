package pe.upc.learningcenterplatform.iam.domain.model.queries;

import pe.upc.learningcenterplatform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
