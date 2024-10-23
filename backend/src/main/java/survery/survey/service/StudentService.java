package survery.survey.service;

import survery.survey.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survery.survey.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a student by roll number
    public Optional<Student> getStudentByRollNo(String rollNo) {
        return studentRepository.findById(rollNo);
    }

    // Save a new student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get students by batch
    public List<Student> getStudentsByBatch(String batch) {
        return studentRepository.findByBatch(batch);
    }

    // Update student details
    public Student updateStudent(String rollNo, Student studentDetails) {
        Optional<Student> studentOptional = studentRepository.findById(rollNo);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDetails.getName());
            student.setBatch(studentDetails.getBatch());
            student.setHasFilledForm(studentDetails.getHasFilledForm());
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with rollNo: " + rollNo);
        }
    }

    // Delete a student
    public void deleteStudent(String rollNo) {
        studentRepository.deleteById(rollNo);
    }
}
