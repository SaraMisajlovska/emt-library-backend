package mk.ukim.finki.emtlibrary.dataholder;


import mk.ukim.finki.emtlibrary.model.Author;
import mk.ukim.finki.emtlibrary.model.Book;
import mk.ukim.finki.emtlibrary.model.Country;
import mk.ukim.finki.emtlibrary.model.dto.AuthorDTO;
import mk.ukim.finki.emtlibrary.model.dto.BookDTO;
import mk.ukim.finki.emtlibrary.model.dto.CountryDTO;
import mk.ukim.finki.emtlibrary.model.enums.Category;
import mk.ukim.finki.emtlibrary.service.AuthorService;
import mk.ukim.finki.emtlibrary.service.BookService;
import mk.ukim.finki.emtlibrary.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataInit {

    private final AuthorService authorService;

    private final BookService bookService;

    private final CountryService countryService;

    public DataInit(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData() {
        this.countryService.save(new CountryDTO("USA", "North America"));
        this.countryService.save(new CountryDTO("France", "Europe"));
//        this.countryService.save(new CountryDTO("Germany", "Europe", new ArrayList<>()));

        List<Country> countries = countryService.findAll();

        this.authorService.save(new AuthorDTO("Edgar Allan", "Poe", countries.get(0)));
        this.authorService.save(new AuthorDTO("Victor", "Hugo", countries.get(1)));
//        this.authorService.save(new AuthorDTO("Johann Wolfgang von", "Goethe", countries.get(2), new ArrayList<>()));
        List<Author> authors = authorService.findAll();

        //this.countryService.findAll().forEach(country -> country.getAuthors().add(authors.get(0)));

       this.bookService.save(new BookDTO("The Raven", Category.CLASSICS, authors.get(0).getId(), 1));
//        this.bookService.save(new BookDTO("Les Miserables", Category.HISTORY, authors.get(1).getId(), 5));
//        this.bookService.save(new BookDTO("The Sorrows of Young Werther", Category.NOVEL, authors.get(2).getId(), 4));
//        List<Book> books = bookService.findAll();
//
//        this.authorService.findAll().forEach(author -> author.getBooks().add(books.get(0)));

    }
}