package pe.upc.learningcenterplatform.learning.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.LearningPath;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;
import pe.upc.learningcenterplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Course extends AuditableAbstractAggregateRoot<Course> {
    private String title;
    private String description;

    @Embedded
    private final LearningPath learningPath;

    public Course() {
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.learningPath = new LearningPath();
    }

    public Course updateInformation(String title, String description) {
        this.title = title;
        this.description = description;
        return this;
    }

    public void addTutorialToLearningPath(TutorialId tutorialId) {
        this.learningPath.addItem(this, tutorialId);
    }

    public void addTutorialToLearningPath(TutorialId tutorialId, TutorialId nextTutorialId) {
        this.learningPath.addItem(this, tutorialId, nextTutorialId);
    }


}
