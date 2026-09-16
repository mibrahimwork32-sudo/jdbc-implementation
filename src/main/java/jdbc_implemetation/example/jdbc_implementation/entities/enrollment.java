package jdbc_implemetation.example.jdbc_implementation.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private students student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private course course;


    public enrollment() {
    }


    public enrollment(students student, course course) {
        this.student = student;
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public students getStudent() {
        return student;
    }

    public void setStudent(students student) {
        this.student = student;
    }


    public course getCourse() {
        return course;
    }

    public void setCourse(course course) {
        this.course = course;
    }
}