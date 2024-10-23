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
public class Student {

    @Id
    @Column(length = 50)
    private String rollNo;

    @Column(length = 100)
    private String name;

    @Column(length = 50)
    private String batch;

    @Column(name = "has_filled_form")
    private Boolean hasFilledForm;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasFilledForm() {
        return hasFilledForm;
    }

    public void setHasFilledForm(Boolean hasFilledForm) {
        this.hasFilledForm = hasFilledForm;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
