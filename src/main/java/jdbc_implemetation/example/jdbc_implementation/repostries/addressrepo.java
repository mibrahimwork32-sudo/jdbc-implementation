package jdbc_implemetation.example.jdbc_implementation.repostries;

import jdbc_implemetation.example.jdbc_implementation.entities.address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface addressrepo extends JpaRepository<address, Long> {

}