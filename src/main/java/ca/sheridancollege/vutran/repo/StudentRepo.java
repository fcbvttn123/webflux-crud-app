package ca.sheridancollege.vutran.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.vutran.beans.Student;

@Repository
public interface StudentRepo extends ReactiveMongoRepository<Student, Long> {

}
