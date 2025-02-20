package project.example.SpringBootCrudUsingMongoDB.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")  // Renamed from "Students" to "students"


public class Students {
    @Id
    private String studentUSN;
    private String StudentName;
    private String phoneNumber;
    private String Section;

    public String getStudentUSN() {
        return studentUSN;
    }

    public void setStudentUSN(String studentUSN) {
        this.studentUSN = studentUSN;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }
}
