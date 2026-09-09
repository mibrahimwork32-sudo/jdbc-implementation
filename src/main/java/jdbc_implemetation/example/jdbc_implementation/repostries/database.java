package jdbc_implemetation.example.jdbc_implementation.repostries;

import jdbc_implemetation.example.jdbc_implementation.models.students;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class database {

    private final JdbcTemplate jdbcTemplate;

    public database(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public int createStudent(students student) {

        String sql = """
                INSERT INTO students
                (name, email, age, department)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getDepartment()
        );
    }

    // READ ALL
    public List<students> getAllStudents() {

        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(
                sql,
                new studentsRowMapper()
        );
    }

    // READ ONE
    public students getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new studentsRowMapper(),
                id
        );
    }

    // UPDATE
    public int updateStudent(students student) {

        String sql = """
                UPDATE students
                SET name = ?,
                    email = ?,
                    age = ?,
                    department = ?
                WHERE id = ?
                """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getDepartment(),
                student.getId()
        );
    }

    // DELETE
    public int deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
}