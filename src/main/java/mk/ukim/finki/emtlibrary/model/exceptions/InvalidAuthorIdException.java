package mk.ukim.finki.emtlibrary.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAuthorIdException extends RuntimeException{
    public InvalidAuthorIdException(Long id) {
        super(String.format("Author with id %d doesn't exist!", id));
    }
}
