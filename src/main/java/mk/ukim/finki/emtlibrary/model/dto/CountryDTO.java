package mk.ukim.finki.emtlibrary.model.dto;

import lombok.Data;
import mk.ukim.finki.emtlibrary.model.Author;

import java.util.List;

@Data
public class CountryDTO {

    String name;

    String continent;


    public CountryDTO(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
