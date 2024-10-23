package survery.survey.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "selected")
public class Selected {

    @Id
    private Integer selectedId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(length = 100)
    private String selectedText;

    private Integer sequence;

    // Getters and Setters
}

