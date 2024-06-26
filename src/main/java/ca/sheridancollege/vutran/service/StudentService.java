package ca.sheridancollege.vutran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.vutran.beans.Student;
import ca.sheridancollege.vutran.repo.StudentRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo sr;
	
	public Flux<Student> getStudents() {
		return sr.findAll();
	}
	
	public Mono<Student> addStudent(Student student) {
        return sr.save(student);
    }
	
	public Mono<Void> deleteStudentById(String id) {
        return sr.deleteById(id);
    }
	
	public Mono<Student> updateStudent(String id, Student updatedStudent) {
        return sr.findById(id).flatMap(existingStudent -> {
             existingStudent.setName(updatedStudent.getName());
             return sr.save(existingStudent);
        });
    }
	
}
