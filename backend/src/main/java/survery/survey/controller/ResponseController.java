package survery.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import survery.survey.model.Question;
import survery.survey.model.Response;
import survery.survey.model.Student;
import survery.survey.service.QuestionService;
import survery.survey.service.ResponseService;
import survery.survey.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private StudentService studentService; // Inject StudentService to fetch students

    @Autowired
    private QuestionService questionService; // Inject QuestionService to fetch questions

    // Get all responses
    @GetMapping
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }

    // Get a response by ID
    @GetMapping("/{responseId}")
    public ResponseEntity<Response> getResponseById(@PathVariable Integer responseId) {
        Optional<Response> response = responseService.getResponseById(responseId);
        return response.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new response
    @PostMapping
    public ResponseEntity<Response> createResponse(@RequestBody Response response) {
        Response newResponse = responseService.saveResponse(response);
        return new ResponseEntity<>(newResponse, HttpStatus.CREATED);
    }

    // Get responses by student
    @GetMapping("/student/{rollNo}")
    public ResponseEntity<List<Response>> getResponsesByStudent(@PathVariable String rollNo) {
        // Fetch the student using StudentService
        Optional<Student> student = studentService.getStudentByRollNo(rollNo);
        return student.map(s -> new ResponseEntity<>(responseService.getResponsesByStudent(s), HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get responses by question
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Response>> getResponsesByQuestion(@PathVariable Integer questionId) {
        // Fetch the question using QuestionService
        Optional<Question> question = questionService.getQuestionById(questionId);
        return question.map(q -> new ResponseEntity<>(responseService.getResponsesByQuestion(q), HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a response
    @DeleteMapping("/{responseId}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Integer responseId) {
        responseService.deleteResponse(responseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
