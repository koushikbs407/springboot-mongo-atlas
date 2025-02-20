package project.example.SpringBootCrudUsingMongoDB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.SpringBootCrudUsingMongoDB.Model.Students;
import project.example.SpringBootCrudUsingMongoDB.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Students> getListStudents(){
        return studentRepository.findAll();
    }

    public Students getStudentByID(String id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    public Students createStudents(Students studentsrequest){
        studentsrequest.setStudentUSN(UUID.randomUUID().toString().split("-")[0]);
        return studentRepository.save(studentsrequest);
    }

    public Students updateStudents(Students studentrequest){
        Students existingStudent = studentRepository.findById(studentrequest.getStudentUSN()).orElse(null);

        if (existingStudent == null) {
            throw new RuntimeException("Student not found with USN: " + studentrequest.getStudentUSN());
        }

        existingStudent.setStudentName(studentrequest.getStudentName());
        existingStudent.setPhoneNumber(studentrequest.getPhoneNumber());
        existingStudent.setSection(studentrequest.getSection());

        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(String studentId){
        if (!studentRepository.existsById(studentId)) {
            return "Student ID not found: " + studentId;
        }
        studentRepository.deleteById(studentId);
        return "Student ID deleted: " + studentId;
    }
    public Students getStudentByPhoneNumber(String phonenumber) {
        return studentRepository.findByPhoneNumber(phonenumber)
                .orElseThrow(() -> new RuntimeException("Student not found with phone number: " + phonenumber)); // ✅ Handle missing student
    }
}
