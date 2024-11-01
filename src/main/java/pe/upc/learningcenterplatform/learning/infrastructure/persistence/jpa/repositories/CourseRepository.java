package pe.upc.learningcenterplatform.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenterplatform.learning.domain.model.aggregates.Course;

import java.util.Optional;

/**
 * Course Repository
 * <p>This interface is used to interact with the database and perform CRUD
 * and business command and query supporting operations on the Course entity.</p>
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

    /**
     * This method is used to find a course by title
     * @param title The title of the course
     * @return And optional of course
     */
    Optional<Course> findByTitle(String title);

    /**
     * This method is used to check if a course exists by title
     * @param title The title of the course
     * @return A boolean indicating if the course exists
     */
    boolean existsByTitle(String title);

    /**
     * This method is used to check if a course exists by title and a different id
     * @param title The title of the course
     * @param id The id of the course
     * @return A boolean indicating if the course exists with the same title and a different id
     */
    boolean existsByTitleAndIdIsNot(String title, String id);
}
