package survery.survey.repository;

import survery.survey.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    // Additional custom query methods can be added here
    List<Student> findByBatch(String batch);
}
