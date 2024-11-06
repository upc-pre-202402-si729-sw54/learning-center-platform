package pe.upc.learningcenterplatform.learning.interfaces.rest.resources;

public record StudentResource(
        String acmeStudentRecordId,
        String profileId,
        Integer totalCompletedCourses,
        Integer totalCompletedTutorials) {
    public StudentResource {
        if (acmeStudentRecordId == null) {
            throw new IllegalArgumentException("acmeStudentRecordId is required");
        }
        if (profileId == null) {
            throw new IllegalArgumentException("profileId is required");
        }
        if (totalCompletedCourses == null) {
            throw new IllegalArgumentException("totalCompletedCourses is required");
        }
        if (totalCompletedTutorials == null) {
            throw new IllegalArgumentException("totalCompletedTutorials is required");
        }
    }
}
