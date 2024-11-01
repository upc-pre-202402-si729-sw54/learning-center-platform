package pe.upc.learningcenterplatform.learning.domain.services;

import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Student;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetStudentByAcmeStudentRecordIdQuery;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetStudentByProfileIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);

    Optional<Student> handle(GetStudentByAcmeStudentRecordIdQuery query);
}
