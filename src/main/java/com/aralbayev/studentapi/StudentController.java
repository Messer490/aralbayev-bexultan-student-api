package com.aralbayev.studentapi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository repository;
    public StudentController(StudentRepository repository) { this.repository = repository; }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) { return repository.save(student); }
    @GetMapping public List<Student> all() { return repository.findAll(); }
    @GetMapping("/{id}") public Student one(@PathVariable Long id) { return find(id); }
    @PutMapping("/{id}") public Student update(@PathVariable Long id, @RequestBody Student incoming) {
        Student student = find(id);
        student.setName(incoming.getName());
        student.setSurname(incoming.getSurname());
        student.setEmail(incoming.getEmail());
        return repository.save(student);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { repository.delete(find(id)); }
    private Student find(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found: " + id)); }
}
