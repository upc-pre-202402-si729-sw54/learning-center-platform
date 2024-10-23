package pe.upc.learningcenterplatform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * Value object representing the student record id
 * @summary
 * This value object is used to represent the student record id.
 * It is an embeddable object that is used as a value object in the student record entity..
 * @param studentRecordId The student record id. It cannot be null or empty.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record AcmeStudentRecordId(String studentRecordId) {

    /**
     * Default constructor
     * @summary
     * This constructor is used to create a new instance of the AcmeStudentRecordId value object.
     * It generates a new UUID and assigns it to the student record id.
     * @since 1.0
     */
    public AcmeStudentRecordId() {
        this(UUID.randomUUID().toString());
    }

    public AcmeStudentRecordId {
        if (studentRecordId == null) {
            throw new IllegalArgumentException("Student Record Id cannot be null");
        }
        if (studentRecordId.isBlank()) {
            throw new IllegalArgumentException("Student Record Id cannot be empty");
        }
    }
}
