package survery.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import survery.survey.model.Question;
import survery.survey.service.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Get a question by ID
    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer questionId) {
        Optional<Question> question = questionService.getQuestionById(questionId);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new question
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question newQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    // Delete a question
    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get questions by batch
    @GetMapping("/batch/{batch}")
    public List<Question> getQuestionsByBatch(@PathVariable String batch) {
        return questionService.getQuestionsByBatch(batch);
    }
}
