# CRUD app using WebFlux

### How to add new Student (in Postmand) 

- URL: http://localhost:8080/students

- Method: POST

- Value: { "name": "John"}

### How to read all Students (in Postmand) 

- URL: http://localhost:8080/students

- Method: GET

### How to delete one Student (in Postmand) 

- URL: http://localhost:8080/students/{id}

- Method: DELETE

### How to update one Student (in Postmand) 

- URL: http://localhost:8080/students/{id}

- Method: UPDATE

# MongDB - Why did I use "String" as data type for ID but not "Long" ? 

- The GenerationType.IDENTITY strategy is specific to relational databases like MySQL, PostgreSQL, etc., and MongoDB doesn't support auto-incremented IDs in the same way

- MongoDB typically uses the ObjectId type for the _id field which is a 12-byte identifier that consists of a timestamp, machine identifier, process identifier, and a random incrementing value

- Example: 
    {
        "id": "660ab40d26330729ee233958",
        "name": "Jain"
    }

# New Knowledge 

### Flux vs Mono 

- Mono: retrieve one element
  
- Flux: retrieve multiple elements

### Flux<> vs List<>

When dealing with potentially long-running operations such as network requests or database queries, they allow you to process data as it becomes available without blocking the execution thread
