package mk.ukim.finki.emtlibrary.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBookIdException extends RuntimeException {
    public InvalidBookIdException(Long id) {
        super(String.format("Book with id %d doesn't exist!", id));
    }
}
