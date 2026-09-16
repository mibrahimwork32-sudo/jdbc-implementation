package jdbc_implemetation.example.jdbc_implementation.dto;

import jdbc_implemetation.example.jdbc_implementation.entities.deparment;
import jdbc_implemetation.example.jdbc_implementation.entities.students;

public class studentresponce {

    private long id;
    private String name;
    private String email;
    private int age;
    private deparment department;

    public studentresponce() {
    }

    public studentresponce(
            long id,
            String name,
            String email,
            int age,
            deparment department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return department;
    }

    public void setDepartment(deparment department) {
        this.department = department;
    }
    public static studentresponce fromEntity(students student) {

        return new studentresponce(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getDepartment()
        );
    }
}