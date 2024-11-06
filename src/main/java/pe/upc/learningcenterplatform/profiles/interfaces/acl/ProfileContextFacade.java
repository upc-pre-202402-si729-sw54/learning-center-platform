package pe.upc.learningcenterplatform.profiles.interfaces.acl;

public interface ProfileContextFacade {

    String createProfile(
            String firstName,
            String lastName,
            String email,
            String street,
            String number,
            String city,
            String postalCode,
            String country
    );

    String fetchProfileIdByEmail(String email);
}
