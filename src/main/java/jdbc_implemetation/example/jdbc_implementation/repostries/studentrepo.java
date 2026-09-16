package jdbc_implemetation.example.jdbc_implementation.repostries;
import jdbc_implemetation.example.jdbc_implementation.entities.*;
import jdbc_implemetation.example.jdbc_implementation.entities.students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface studentrepo extends JpaRepository <students,Long> {

        Optional<students> findByEmail(String email);

        List<students> findByDepartment(deparment department);

        List<students> findByNameContainingIgnoreCase(String name);

        Page<students> findAll(Pageable pageable);
    }
