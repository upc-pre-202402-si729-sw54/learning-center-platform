package pe.upc.learningcenterplatform.learning.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Enrollment;
import pe.upc.learningcenterplatform.learning.domain.model.entities.ProgressRecordItem;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ProgressRecord {

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<ProgressRecordItem> progressRecordItems;

    public ProgressRecord() {
        progressRecordItems = new ArrayList<>();
    }

    /**
     * Initialize the progress record with the first tutorial in the learning path
     *
     * @param enrollment   Enrollment
     * @param learningPath LearningPath
     * @see ProgressRecordItem
     * @see Enrollment
     * @see LearningPath
     * @since 1.0
     */
    public void initializeProgressRecord(Enrollment enrollment, LearningPath learningPath) {
        if (learningPath.isEmpty()) return;
        TutorialId tutorialId = learningPath.getFirstTutorialInLearningPath();
        ProgressRecordItem progressRecordItem = new ProgressRecordItem(enrollment, tutorialId);
        progressRecordItems.add(progressRecordItem);
    }

    private ProgressRecordItem getProgressRecordItemWithTutorialId(TutorialId tutorialId) {
        return progressRecordItems.stream()
                .filter(progressRecordItem -> progressRecordItem.getTutorialId().equals(tutorialId))
                .findFirst()
                .orElse(null);
    }

    private boolean hasAnItemInProgress() {
        return progressRecordItems.stream().anyMatch(ProgressRecordItem::isInProgress);
    }

    public void startTutorial(TutorialId tutorialId) {
        if(hasAnItemInProgress()) throw new IllegalStateException("A tutorial is already in progress");

        ProgressRecordItem progressRecordItem = getProgressRecordItemWithTutorialId(tutorialId);

        if (progressRecordItem != null){
            if(progressRecordItem.isNotStarted()) progressRecordItem.start();
            else throw new IllegalStateException("The tutorial has already been started or completed");
        } else {
            throw new IllegalArgumentException("Tutorial with given Id not found in the progress record");
        }
    }

    public long calculateDaysElapsedForEnrollment(Enrollment enrollment){
        return progressRecordItems.stream()
                .filter(progressRecordItem -> progressRecordItem.getEnrollment().equals(enrollment))
                .mapToLong(ProgressRecordItem::calculateDaysElapsed)
                .sum();
    }
}
