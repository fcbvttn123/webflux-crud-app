package ca.sheridancollege.vutran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

import ca.sheridancollege.vutran.beans.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class StudentWebClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentWebClient.class);
	WebClient client = WebClient.create("http://localhost:8080");
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
	    Mono<List<Student>> studentMono = client.get()
	        .uri("/students")
	        .retrieve()
	        .bodyToFlux(Student.class)
	        .collectList();

	    List<Student> students = studentMono.block();
	    model.addAttribute("studentList", students);
	    LOGGER.info("Retrieved students: {}", students);

	    return "index";
	}
	
	@GetMapping("/live")
	public String getIndexLive(Model model) {
	    Flux<Student> liveStudentFlux = client.get()
	        .uri("/students/live")
	        .retrieve()
	        .bodyToFlux(Student.class);

	    liveStudentFlux.subscribe(student -> {
	        LOGGER.info("Live Student: {}", student);
	    });

	    return "index";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student student, Model model) {
	    client.post()
	         .uri("/students")
	         .body(Mono.just(student), Student.class)
	         .retrieve()
	         .bodyToMono(Void.class)
	         .subscribe(); 
	    return "redirect:/";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable String id) {
	    client.delete()
	         .uri("/students/{id}", id)
	         .retrieve()
	         .bodyToMono(Void.class)
	         .subscribe(); 
	    return "redirect:/";
	}
	
}
