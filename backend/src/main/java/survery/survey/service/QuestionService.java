package survery.survey.service;

import survery.survey.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survery.survey.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // Get all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Get question by ID
    public Optional<Question> getQuestionById(Integer questionId) {
        return questionRepository.findById(questionId);
    }

    // Save a new question
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Get questions by batch
    public List<Question> getQuestionsByBatch(String batch) {
        return questionRepository.findByBatch(batch);
    }

    // Delete a question
    public void deleteQuestion(Integer questionId) {
        questionRepository.deleteById(questionId);
    }
}
