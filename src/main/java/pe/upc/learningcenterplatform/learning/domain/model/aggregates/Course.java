package pe.upc.learningcenterplatform.learning.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import pe.upc.learningcenterplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Course extends AuditableAbstractAggregateRoot<Course> {
    private String title;
    private String description;
}
