package mk.ukim.finki.emtlibrary.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;

    @ManyToOne
    Country country;

    @OneToMany
    List<Book> books;

    public Author() {
    }

    public Author(String name, String surname, Country country, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.books = books;
    }
}
