package mk.ukim.finki.emtlibrary.service;

import mk.ukim.finki.emtlibrary.model.Book;
import mk.ukim.finki.emtlibrary.model.dto.BookDTO;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDTO bookDTO);

    Optional<Book> edit(Long id, BookDTO bookDTO);

    void deleteById(Long id);

    Optional<Book> taken(Long id);

}
