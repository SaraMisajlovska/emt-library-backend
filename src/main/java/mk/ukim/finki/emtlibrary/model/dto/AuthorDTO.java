package mk.ukim.finki.emtlibrary.model.dto;

import lombok.Data;
import mk.ukim.finki.emtlibrary.model.Book;
import mk.ukim.finki.emtlibrary.model.Country;

import java.util.List;
@Data
public class AuthorDTO {

    String name;

    String surname;

    Country country;



    public AuthorDTO(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;

    }
}
