package mk.ukim.finki.emtlibrary.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCountryIdException extends RuntimeException {
    public InvalidCountryIdException(Long id) {
        super(String.format("Country with id %d doesn't exist!", id));
    }
}
