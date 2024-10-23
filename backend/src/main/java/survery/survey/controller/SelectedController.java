package survery.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import survery.survey.model.Selected; // Updated import to Selected
import survery.survey.model.Question;
import survery.survey.service.SelectedService; // Updated service to SelectedService
import survery.survey.service.QuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/selected") // Updated endpoint to /api/selected
public class SelectedController {

    @Autowired
    private SelectedService selectedService; // Updated service to SelectedService

    @Autowired
    private QuestionService questionService; // Inject QuestionService to fetch questions

    // Get all selected options
    @GetMapping
    public List<Selected> getAllSelected() {
        return selectedService.getAllSelected(); // Updated method call
    }

    // Get a selected option by ID
    @GetMapping("/{selectedId}") // Updated parameter name
    public ResponseEntity<Selected> getSelectedById(@PathVariable Integer selectedId) { // Updated method name
        Optional<Selected> selected = selectedService.getSelectedById(selectedId); // Updated method call
        return selected.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new selected option
    @PostMapping
    public ResponseEntity<Selected> createSelected(@RequestBody Selected selected) { // Updated parameter type
        Selected newSelected = selectedService.saveSelected(selected); // Updated method call
        return new ResponseEntity<>(newSelected, HttpStatus.CREATED);
    }

    // Get selected options by question
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Selected>> getSelectedByQuestion(@PathVariable Integer questionId) { // Updated method name and return type
        // Fetch the question using QuestionService
        Optional<Question> question = questionService.getQuestionById(questionId);
        return question.map(q -> new ResponseEntity<>(selectedService.getSelectedByQuestion(q), HttpStatus.OK)) // Updated method call
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a selected option by ID
    @DeleteMapping("/{selectedId}") // Updated parameter name
    public ResponseEntity<Void> deleteSelected(@PathVariable Integer selectedId) { // Updated method name
        selectedService.deleteSelected(selectedId); // Updated method call
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
