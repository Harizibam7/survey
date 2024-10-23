package survery.survey.repository;

import survery.survey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Custom query to find questions by batch
    List<Question> findByBatch(String batch);
}
