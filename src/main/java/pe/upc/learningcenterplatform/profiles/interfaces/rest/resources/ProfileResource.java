package pe.upc.learningcenterplatform.profiles.interfaces.rest.resources;

public record ProfileResource(String id,
                              String fullName,
                              String email,
                              String streetAddress) {
}
