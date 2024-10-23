package survery.survey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Response {

    @Id
    private Integer responseId;

    @ManyToOne
    @JoinColumn(name = "roll_no", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "selected_option", nullable = false)
    private Selected selectedOption;

    // Getters and Setters
}
