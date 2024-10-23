package survery.survey.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {

    @Id
    private Integer questionId;

    @Column(length = 250)
    private String questionText;

    @Column(length = 50)
    private String batch;


}
