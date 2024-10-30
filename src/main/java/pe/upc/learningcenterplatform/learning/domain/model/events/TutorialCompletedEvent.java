package pe.upc.learningcenterplatform.learning.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;

@Getter
public class TutorialCompletedEvent extends ApplicationEvent {
    private final Long enrollmentId;
    private final TutorialId tutorialId;

    public TutorialCompletedEvent(Object source, Long enrollmentId, TutorialId tutorialId) {
        super(source);
        this.enrollmentId = enrollmentId;
        this.tutorialId = tutorialId;
    }
}
