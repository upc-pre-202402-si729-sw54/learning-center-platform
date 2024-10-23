package pe.upc.learningcenterplatform.learning.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;
import pe.upc.learningcenterplatform.shared.domain.model.entities.AuditableModel;

@Getter
@Entity
public class LearningPathItem extends AuditableModel {

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course;

    @Embedded
    @Column(name = "tutorial_id")
    @NotNull
    private TutorialId tutorialId;

    @ManyToOne
    @JoinColumn(name = "next_item_id")
    private LearningPathItem nextItem;

    public LearningPathItem() {
        this.tutorialId = new TutorialId(0L);
        this.nextItem = null;
    }

    public LearningPathItem(Course course, TutorialId tutorialId, LearningPathItem nextItem) {
        this.course = course;
        this.tutorialId = tutorialId;
        this.nextItem = nextItem;
    }

    public void updateNextItem(LearningPathItem nextItem) {
        this.nextItem = nextItem;
    }


}
