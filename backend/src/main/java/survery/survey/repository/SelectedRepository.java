package survery.survey.repository;

import survery.survey.model.Selected; // Updated import to Selected
import survery.survey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectedRepository extends JpaRepository<Selected, Integer> { // Updated repository name
    // Custom query to get selected options for a specific question
    List<Selected> findByQuestion(Question question); // Updated return type
}
