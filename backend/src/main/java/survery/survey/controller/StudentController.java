package survery.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import survery.survey.model.Student;
import survery.survey.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by roll number
    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable String rollNo) {
        Optional<Student> student = studentService.getStudentByRollNo(rollNo);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    // Update a student
    @PutMapping("/{rollNo}")
    public ResponseEntity<Student> updateStudent(@PathVariable String rollNo, @RequestBody Student studentDetails) {
        try {
            Student updatedStudent = studentService.updateStudent(rollNo, studentDetails);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a student
    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String rollNo) {
        studentService.deleteStudent(rollNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get students by batch
    @GetMapping("/batch/{batch}")
    public List<Student> getStudentsByBatch(@PathVariable String batch) {
        return studentService.getStudentsByBatch(batch);
    }
}
