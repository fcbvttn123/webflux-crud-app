package ca.sheridancollege.vutran.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.vutran.beans.Student;
import ca.sheridancollege.vutran.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired 
	private StudentService service; 
	
	@GetMapping
	public Flux<Student> getStudents() {
		return service.getStudents();
	}
	
	@PostMapping()
	public Mono<Student> insertStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}
	
}
