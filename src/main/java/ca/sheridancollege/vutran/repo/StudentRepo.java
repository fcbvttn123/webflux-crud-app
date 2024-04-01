package ca.sheridancollege.vutran.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.vutran.beans.Student;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
	public Mono<Void> deleteStudentById(String id);
}
