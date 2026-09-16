package jdbc_implemetation.example.jdbc_implementation.services;

import jdbc_implemetation.example.jdbc_implementation.entities.students;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class jpaLearningService {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public students persistStudent(students student) {

        entityManager.persist(student);

        return student;
    }

    public students findStudent(Long id) {

        return entityManager.find(
                students.class,
                id
        );
    }

    @Transactional
    public students mergeStudent(students student) {

        return entityManager.merge(student);
    }

    @Transactional
    public void removeStudent(Long id) {

        students student =
                entityManager.find(
                        students.class,
                        id
                );

        if (student != null) {

            entityManager.remove(student);
        }
    }



    @Transactional
    public void changeStudentName(
            Long id,
            String newName
    ) {

        students student =
                entityManager.find(
                        students.class,
                        id
                );

        if (student != null) {
            student.setName(newName);

        }
    }
}