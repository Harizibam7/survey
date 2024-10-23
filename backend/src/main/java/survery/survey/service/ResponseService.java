package survery.survey.service;

import survery.survey.model.Question;
import survery.survey.model.Response;
import survery.survey.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survery.survey.repository.ResponseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    // Get all responses
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    // Get response by ID
    public Optional<Response> getResponseById(Integer responseId) {
        return responseRepository.findById(responseId);
    }

    // Save a new response
    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    // Get responses by student
    public List<Response> getResponsesByStudent(Student student) {
        return responseRepository.findByStudent(student);
    }

    // Get responses by question
    public List<Response> getResponsesByQuestion(Question question) {
        return responseRepository.findByQuestion(question);
    }

    // Delete a response
    public void deleteResponse(Integer responseId) {
        responseRepository.deleteById(responseId);
    }
}
