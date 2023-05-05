package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity noValid(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ErrorDto::new).toList());
    }

    private record ErrorDto(String field, String message) {
        public ErrorDto(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
