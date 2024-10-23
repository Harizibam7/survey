package survery.survey.repository;

import survery.survey.model.Question;
import survery.survey.model.Response;
import survery.survey.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
    // Custom query to get responses by student
    List<Response> findByStudent(Student student);

    // Custom query to get responses for a specific question
    List<Response> findByQuestion(Question question);
}
