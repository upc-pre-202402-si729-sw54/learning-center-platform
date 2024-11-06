package pe.upc.learningcenterplatform.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.learningcenterplatform.learning.domain.model.queries.GetStudentByAcmeStudentRecordIdQuery;
import pe.upc.learningcenterplatform.learning.domain.services.StudentCommandService;
import pe.upc.learningcenterplatform.learning.domain.services.StudentQueryService;
import pe.upc.learningcenterplatform.learning.interfaces.rest.resources.CreateStudentResource;
import pe.upc.learningcenterplatform.learning.interfaces.rest.resources.StudentResource;
import pe.upc.learningcenterplatform.learning.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import pe.upc.learningcenterplatform.learning.interfaces.rest.transform.StudentResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Available Students API")
public class StudentController {

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new student", description = "Create a new student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public ResponseEntity<StudentResource> createStudent(CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var acmeStudentRecordId = studentCommandService.handle(createStudentCommand);

        if (acmeStudentRecordId.studentRecordId().isEmpty()) return ResponseEntity.badRequest().build();

        var getStudentByAcmeStudentRecordIdQuery = new GetStudentByAcmeStudentRecordIdQuery(acmeStudentRecordId);
        var student = studentQueryService.handle(getStudentByAcmeStudentRecordIdQuery);

        if (student.isEmpty()) return ResponseEntity.notFound().build();

        var createedStudent = student.get();
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(createedStudent);

        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }


}
