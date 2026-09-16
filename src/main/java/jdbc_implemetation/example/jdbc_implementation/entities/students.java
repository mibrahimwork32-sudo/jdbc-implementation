package jdbc_implemetation.example.jdbc_implementation.entities;

import jdbc_implemetation.example.jdbc_implementation.entities.deparment;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private deparment deparment;

    /*
     * @Transient means this field is NOT stored
     * in the database.
     */
    @Transient
    private String temporaryMessage;


    /*
     * ONE STUDENT -> ONE ADDRESS
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private address address;


    /*
     * ONE STUDENT -> MANY ENROLLMENTS
     *
     * mappedBy = "student" means the student field
     * inside enrollment owns this relationship.
     */
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<enrollment> enrollments = new ArrayList<>();


    /*
     * MANY STUDENTS -> MANY COURSES
     *
     * This creates a join table called student_courses.
     */
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<course> courses = new ArrayList<>();


    public students() {
    }


    public students(
            String name,
            String email,
            int age,
            deparment deparment
    ) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.deparment = deparment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public deparment getDepartment() {
        return deparment;
    }

    public void setDepartment(deparment department) {
        this.deparment = department;
    }


    public String getTemporaryMessage() {
        return temporaryMessage;
    }

    public void setTemporaryMessage(String temporaryMessage) {
        this.temporaryMessage = temporaryMessage;
    }


    public address getAddress() {
        return address;
    }

    public void setAddress(address address) {
        this.address = address;
    }


    public List<enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<enrollment> enrollments) {
        this.enrollments = enrollments;
    }


    public List<course> getCourses() {
        return courses;
    }

    public void setCourses(List<course> courses) {
        this.courses = courses;
    }
}