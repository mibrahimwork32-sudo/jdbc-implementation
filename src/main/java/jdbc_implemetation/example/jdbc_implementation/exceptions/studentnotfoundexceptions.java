package jdbc_implemetation.example.jdbc_implementation.exceptions;

public class studentnotfoundexceptions extends RuntimeException {

    public studentnotfoundexceptions(Long id) {
        super("Student not found with id: " + id);
    }
}
