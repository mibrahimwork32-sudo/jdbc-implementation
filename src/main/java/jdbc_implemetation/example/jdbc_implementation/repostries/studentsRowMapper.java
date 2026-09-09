package jdbc_implemetation.example.jdbc_implementation.repostries;
import jdbc_implemetation.example.jdbc_implementation.models.students;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class studentsRowMapper implements RowMapper<students> {

        @Override
        public students mapRow(ResultSet rs, int rowNum) throws SQLException {

            students student = new students();

            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));
            student.setDepartment(rs.getString("department"));

            return student;
        }
    }
