package survery.survey.service;

import survery.survey.model.Selected; // Updated import to Selected
import survery.survey.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survery.survey.repository.SelectedRepository; // Updated repository import

import java.util.List;
import java.util.Optional;

@Service
public class SelectedService {

    @Autowired
    private SelectedRepository selectedRepository; // Updated repository name

    // Get all selected options
    public List<Selected> getAllSelected() { // Updated method name
        return selectedRepository.findAll();
    }

    // Get selected option by ID
    public Optional<Selected> getSelectedById(Integer selectedId) { // Updated method name and parameter
        return selectedRepository.findById(selectedId);
    }

    // Save a new selected option
    public Selected saveSelected(Selected selected) { // Updated method name and parameter type
        return selectedRepository.save(selected);
    }

    // Get selected options by question
    public List<Selected> getSelectedByQuestion(Question question) { // Updated method name and return type
        return selectedRepository.findByQuestion(question);
    }

    // Delete a selected option
    public void deleteSelected(Integer selectedId) { // Updated method name and parameter
        selectedRepository.deleteById(selectedId);
    }
}
