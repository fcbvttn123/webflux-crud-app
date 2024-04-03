package ca.sheridancollege.vutran.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value="/live", produces="text/event-stream")
	public Flux<Student> getStudentsLive() {
	    return service.getStudents();
	}
	
	@PostMapping()
	public Mono<Student> insertStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}
	
	@DeleteMapping("/{id}")
    public Mono<Void> deleteStudent(@PathVariable String id) {
        return service.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public Mono<Student> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        return service.updateStudent(id, updatedStudent);
    }
	
}
