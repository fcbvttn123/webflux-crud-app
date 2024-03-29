# CRUD app using WebFlux

### How to add new Student (in Postmand) 

- URL: http://localhost:8080/students

- Method: POST

- Value: { "id": 1, "name": "John"}

### How to read all Students (in Postmand) 

- URL: http://localhost:8080/students

- Method: GET

# New Knowledge 

### Flux vs Mono 

- Mono: retrieve one element
  
- Flux: retrieve multiple elements

### Flux<> vs List<>

When dealing with potentially long-running operations such as network requests or database queries, they allow you to process data as it becomes available without blocking the execution thread
