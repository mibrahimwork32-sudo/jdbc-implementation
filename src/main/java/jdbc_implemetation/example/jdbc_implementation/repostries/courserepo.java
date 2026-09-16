package jdbc_implemetation.example.jdbc_implementation.repostries;

import jdbc_implemetation.example.jdbc_implementation.entities.course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface courserepo extends JpaRepository<course, Long> {

    Optional<course> findByCourseCode(String courseCode);

}