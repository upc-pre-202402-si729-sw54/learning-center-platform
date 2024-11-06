package pe.upc.learningcenterplatform.learning.interfaces.rest.resources;

public record CreateStudentResource(
        String firstName,
        String lastName,
        String email,
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    public CreateStudentResource {
        if (firstName.isBlank()) {
            throw new IllegalArgumentException("firstName is mandatory");
        }
        if (lastName.isBlank()) {
            throw new IllegalArgumentException("lastName is mandatory");
        }
        if (email.isBlank()) {
            throw new IllegalArgumentException("email is mandatory");
        }
        if (street.isBlank()) {
            throw new IllegalArgumentException("street is mandatory");
        }
        if (number.isBlank()) {
            throw new IllegalArgumentException("number is mandatory");
        }
        if (city.isBlank()) {
            throw new IllegalArgumentException("city is mandatory");
        }
        if (postalCode.isBlank()) {
            throw new IllegalArgumentException("postalCode is mandatory");
        }
        if (country.isBlank()) {
            throw new IllegalArgumentException("country is mandatory");
        }
    }
}
