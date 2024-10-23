package pe.upc.learningcenterplatform.learning.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;
import pe.upc.learningcenterplatform.learning.domain.model.entities.LearningPathItem;

import java.util.List;
import java.util.Objects;

@Embeddable
public class LearningPath {

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<LearningPathItem> learningPathItems;

    public LearningPath() {
        this.learningPathItems = List.of();
    }

    /**
     * Check if the learning path is empty
     * @return True if the learning path is empty, false otherwise
     */
    public boolean isEmpty() {
        return learningPathItems.isEmpty();
    }

    /**
     * Get the last tutorial in the learning path
     * @return The id of the last tutorial in the learning path
     */
    public LearningPathItem getLastItemInLearningPath() {
        return learningPathItems.stream()
                .filter(item -> Objects.isNull(item.getNextItem()))
                .findFirst()
                .orElse(null);
    }


    public LearningPathItem getLearningPathItemWithTutorialId(TutorialId tutorialId) {
        return learningPathItems.stream()
                .filter(item -> item.getTutorialId().equals(tutorialId))
                .findFirst()
                .orElse(null);
    }

    /**
     * Add a new item to the learning path
     * @param course The course of the new item
     * @param tutorialId The tutorial id of the new item
     */
    public void addItem(Course course, TutorialId tutorialId) {
        // Add the new item to the end of learning path
        LearningPathItem learningPathItem = new LearningPathItem(course, tutorialId, null);
        LearningPathItem originalLastItem = null;

        if (!isEmpty()) originalLastItem = getLastItemInLearningPath();

        learningPathItems.add(learningPathItem);

        if (!Objects.isNull(originalLastItem)) originalLastItem.updateNextItem(learningPathItem);

    }

    /**
     * Add a new item to the learning path with next item
     * @param course The course of the new item
     * @param tutorialId The tutorial id of the new item
     * @param nextItem The next item in the learning path
     */
    public void addItem(Course course, TutorialId tutorialId, LearningPathItem nextItem){
        // Add the new item to the learning path before the next item
        LearningPathItem learningPathItem = new LearningPathItem(course, tutorialId, nextItem);
        learningPathItems.add(learningPathItem);
    }

    /**
     * Add a new item to the learning path before the next item
     * @param course The course of the new item
     * @param tutorialId The tutorial id of the new item
     * @param nextTutorialId The tutorial id of the next item
     */
    public void addItem(Course course, TutorialId tutorialId, TutorialId nextTutorialId) {
        // Add the new item to the learning path before the next item
        LearningPathItem nextLearningPathItem = getLearningPathItemWithTutorialId(nextTutorialId);
        addItem(course, tutorialId, nextTutorialId);
    }
}
