package mk.ukim.finki.emtlibrary.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emtlibrary.model.enums.Category;


@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Category category;

    @ManyToOne
    Author author;

    public Book() {
    }

    public Book(String name, Category category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }
}
