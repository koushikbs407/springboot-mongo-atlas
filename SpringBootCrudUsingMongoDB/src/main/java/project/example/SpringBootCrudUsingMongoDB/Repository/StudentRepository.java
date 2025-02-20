package project.example.SpringBootCrudUsingMongoDB.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.example.SpringBootCrudUsingMongoDB.Model.Students;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Students,String> {
   Optional<Students> findByPhoneNumber(String phoneNumber);

}
