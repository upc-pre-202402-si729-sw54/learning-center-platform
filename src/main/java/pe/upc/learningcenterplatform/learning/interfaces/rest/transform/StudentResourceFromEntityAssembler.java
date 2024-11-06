package pe.upc.learningcenterplatform.learning.interfaces.rest.transform;

import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Student;
import pe.upc.learningcenterplatform.learning.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity) {

        return new StudentResource(entity.getStudentRecordId(),
                entity.getProfileId(),
                entity.getTotalCompletedCourses(),
                entity.getTotalCompletedTutorials());

    }
}
