package jdbc_implemetation.example.jdbc_implementation.services;

import jdbc_implemetation.example.jdbc_implementation.entities.students;
import jdbc_implemetation.example.jdbc_implementation.repostries.studentrepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentservices {

    private final studentrepo studentrepo;


    public studentservices(studentrepo studentrepo) {
        this.studentrepo = studentrepo;
    }


    // CREATE
    public students createStudent(students student) {

        return studentrepo.save(student);
    }


    // READ ALL
    public List<students> getAllStudents() {

        return studentrepo.findAll();
    }


    // READ BY ID
    public Optional<students> getStudentById(Long id) {

        return studentrepo.findById(id);
    }


    // FIND BY EMAIL
    public Optional<students> getStudentByEmail(String email) {

        return studentrepo.findByEmail(email);
    }


    // UPDATE
    public Optional<students> updateStudent(
            Long id,
            students newStudent
    ) {

        Optional<students> existingStudent =
                studentrepo.findById(id);

        if (existingStudent.isEmpty()) {

            return Optional.empty();
        }

        students student = existingStudent.get();

        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student.setAge(newStudent.getAge());
        student.setDepartment(newStudent.getDepartment());

        return Optional.of(studentrepo.save(student));
    }


    // DELETE
    public boolean deleteStudent(Long id) {

        if (!studentrepo.existsById(id)) {

            return false;
        }

        studentrepo.deleteById(id);

        return true;
    }
}