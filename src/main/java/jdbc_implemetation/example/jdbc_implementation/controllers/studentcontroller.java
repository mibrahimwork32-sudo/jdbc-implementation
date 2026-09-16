package jdbc_implemetation.example.jdbc_implementation.controllers;

import jdbc_implemetation.example.jdbc_implementation.entities.students;
import jdbc_implemetation.example.jdbc_implementation.services.studentservices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class studentcontroller {

    private final studentservices studentservices;


    public studentcontroller(studentservices studentservices) {

        this.studentservices = studentservices;
    }


    // CREATE
    @PostMapping
    public ResponseEntity<students> createStudent(
            @RequestBody students student) {

        students savedStudent =
                studentservices.createStudent(student);

        return ResponseEntity.ok(savedStudent);
    }


    // READ ALL
    @GetMapping
    public ResponseEntity<List<students>> getAllStudents() {

        return ResponseEntity.ok(
                studentservices.getAllStudents()
        );
    }


    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<students> getStudentById(
            @PathVariable Long id) {

        return studentservices.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }


    // FIND BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<students> getStudentByEmail(
            @PathVariable String email) {

        return studentservices
                .getStudentByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<students> updateStudent(
            @PathVariable Long id,
            @RequestBody students student) {

        return studentservices
                .updateStudent(id, student)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {

        if (!studentservices.deleteStudent(id)) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}