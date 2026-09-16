package jdbc_implemetation.example.jdbc_implementation.dto;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import jdbc_implemetation.example.jdbc_implementation.entities.deparment;

public class studentrequest {

        @NotBlank(message = "Name is required")
        @Size(
                min = 3,
                max = 100,
                message = "Name must contain 3 to 100 characters"
        )
        private String name;

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        private String email;

        @NotNull(message = "Age is required")
        @Min(value = 18, message = "Age must be at least 18")
        @Max(value = 60, message = "Age cannot be greater than 60")
        private Integer age;

        @NotNull(message = "Department is required")
        private deparment department;

        public studentrequest() {
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

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public deparment getDepartment() {
            return department;
        }

        public void setDepartment(deparment department) {
            this.department = department;
        }
    }
