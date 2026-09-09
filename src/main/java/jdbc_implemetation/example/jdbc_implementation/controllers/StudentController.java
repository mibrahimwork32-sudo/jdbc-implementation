package jdbc_implemetation.example.jdbc_implementation.controllers;

import jdbc_implemetation.example.jdbc_implementation.models.students;
import jdbc_implemetation.example.jdbc_implementation.repostries.database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final database database;

    public StudentController(database database) {
        this.database = database;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody students student) {

        database.createStudent(student);

        return ResponseEntity.ok(
                "student created successfully"
        );
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<students>> getAllStudents() {

        List<students> studentList =
                database.getAllStudents();

        return ResponseEntity.ok(studentList);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<students> getStudentById(
            @PathVariable int id) {

        students student =
                database.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @RequestBody students student) {

        student.setId(id);

        database.updateStudent(student);

        return ResponseEntity.ok(
                "student updated successfully"
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int id) {

        database.deleteStudent(id);

        return ResponseEntity.ok(
                "student deleted successfully"
        );
    }
}