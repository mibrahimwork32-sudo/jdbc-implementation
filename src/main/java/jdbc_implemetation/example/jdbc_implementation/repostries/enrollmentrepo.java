package jdbc_implemetation.example.jdbc_implementation.repostries;

import jdbc_implemetation.example.jdbc_implementation.entities.enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface enrollmentrepo extends JpaRepository<enrollment, Long> {

    List<enrollment> findByStudentId(Long studentId);

    List<enrollment> findByCourseId(Long courseId);

}