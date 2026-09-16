package jdbc_implemetation.example.jdbc_implementation.controllers;

import jdbc_implemetation.example.jdbc_implementation.entities.students;
import jdbc_implemetation.example.jdbc_implementation.services.jpaLearningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jpa")
public class jpaLearningController {

    private final jpaLearningService jpaLearningService;


    public jpaLearningController(
            jpaLearningService jpaLearningService
    ) {

        this.jpaLearningService = jpaLearningService;
    }
    @PostMapping("/persist")
    public ResponseEntity<students> persistStudent(
            @RequestBody students student
    ) {

        return ResponseEntity.ok(
                jpaLearningService.persistStudent(student)
        );
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<students> findStudent(
            @PathVariable Long id
    ) {

        students student =
                jpaLearningService.findStudent(id);

        if (student == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }
    @PutMapping("/merge")
    public ResponseEntity<students> mergeStudent(
            @RequestBody students student
    ) {

        return ResponseEntity.ok(
                jpaLearningService.mergeStudent(student)
        );
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeStudent(
            @PathVariable Long id
    ) {

        jpaLearningService.removeStudent(id);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/dirty-check/{id}")
    public ResponseEntity<String> dirtyChecking(
            @PathVariable Long id,
            @RequestParam String name
    ) {

        jpaLearningService.changeStudentName(
                id,
                name
        );

        return ResponseEntity.ok(
                "Student name changed using dirty checking"
        );
    }
}