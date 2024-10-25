package pe.upc.learningcenterplatform.learning.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Enrollment;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.ProgressStatus;
import pe.upc.learningcenterplatform.learning.domain.model.valueobjects.TutorialId;
import pe.upc.learningcenterplatform.shared.domain.model.entities.AuditableModel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Entity
public class ProgressRecordItem extends AuditableModel {

    @Getter
    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Getter
    private TutorialId tutorialId;

    private ProgressStatus progressStatus;

    private Date startedAt;

    private Date completedAt;

    public ProgressRecordItem() {
        // Required by JPA
    }

    public ProgressRecordItem(Enrollment enrollment, TutorialId tutorialId) {
        this.enrollment = enrollment;
        this.tutorialId = tutorialId;
        this.progressStatus = ProgressStatus.NOT_STARTED;
    }

    public void start() {
        this.progressStatus = ProgressStatus.STARTED;
        this.startedAt = new Date();
    }

    public void complete() {
        this.progressStatus = ProgressStatus.COMPLETED;
        this.completedAt = new Date();
    }

    public boolean isCompleted() {
        return ProgressStatus.COMPLETED.equals(this.progressStatus);
    }

    public boolean isInProgress() {
        return ProgressStatus.STARTED.equals(this.progressStatus);
    }

    public boolean isNotStarted() {
        return ProgressStatus.NOT_STARTED.equals(this.progressStatus);
    }

    /**
     * Calculate the days elapsed from the started date to the completed date.
     *
     * @return The number of days elapsed.
     * @summany This method calculates the days elapsed from the started date to the completed date.
     * If there is no progress yes, it returns 0.
     * If the item is in progress, it returns the days elapsed from the started date to the current date.
     * If the item is completed, it returns the days elapsed from the started date to the completed date.
     */
    public long calculateDaysElapsed() {
        if (ProgressStatus.NOT_STARTED.equals(this.progressStatus)) {
            return 0L;
        }
        var defaultTimeZone = ZoneId.systemDefault();

        var fromDate = this.startedAt.toInstant().atZone(defaultTimeZone);
        var toDate = Objects.isNull(this.completedAt)
                ? LocalDate.now().atStartOfDay(defaultTimeZone).toInstant()
                : this.completedAt.toInstant().atZone(defaultTimeZone);

        return Duration.between(fromDate, toDate).toDays();
    }
}
