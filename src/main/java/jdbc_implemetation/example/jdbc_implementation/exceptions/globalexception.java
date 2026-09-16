package jdbc_implemetation.example.jdbc_implementation.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;


    @RestControllerAdvice
    public class globalexception {

        @ExceptionHandler(studentnotfoundexceptions.class)
        public ResponseEntity<Map<String, Object>> handleStudentNotFound(
                studentnotfoundexceptions exception
        ) {

            Map<String, Object> error = Map.of(
                    "timestamp", LocalDateTime.now(),
                    "status", HttpStatus.NOT_FOUND.value(),
                    "error", exception.getMessage()
            );

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Map<String, Object>> handleGeneralException(
                Exception exception
        ) {

            Map<String, Object> error = Map.of(
                    "timestamp", LocalDateTime.now(),
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "error", exception.getMessage()
            );

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

