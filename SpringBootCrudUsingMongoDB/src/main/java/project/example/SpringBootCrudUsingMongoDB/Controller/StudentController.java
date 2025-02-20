package project.example.SpringBootCrudUsingMongoDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.SpringBootCrudUsingMongoDB.Model.Students;
import project.example.SpringBootCrudUsingMongoDB.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ✅ GET: Fetch all students
    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        return ResponseEntity.ok(studentService.getListStudents());
    }

    // ✅ GET: Fetch student by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(studentService.getStudentByID(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ POST: Create a new student
    @PostMapping
    public ResponseEntity<Students> createStudent(@RequestBody Students student) {
        return ResponseEntity.ok(studentService.createStudents(student));
    }

    // ✅ PUT: Update student details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody Students student) {
        try {
            student.setStudentUSN(id); // Ensure ID consistency
            return ResponseEntity.ok(studentService.updateStudents(student));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ DELETE: Remove student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }
}
