package mk.ukim.finki.emtlibrary.service.impl;

import mk.ukim.finki.emtlibrary.model.Author;
import mk.ukim.finki.emtlibrary.model.Book;
import mk.ukim.finki.emtlibrary.model.dto.BookDTO;
import mk.ukim.finki.emtlibrary.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.emtlibrary.model.exceptions.InvalidBookIdException;
import mk.ukim.finki.emtlibrary.repository.AuthorRepository;
import mk.ukim.finki.emtlibrary.repository.BookRepository;
import mk.ukim.finki.emtlibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        Author author = this.authorRepository
                .findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new InvalidAuthorIdException(bookDTO.getAuthorId()));

        Book book = new Book(
                bookDTO.getName(),
                bookDTO.getCategory(),
                author,
                bookDTO.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new InvalidBookIdException(id));

        Author author = this.authorRepository
                .findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new InvalidAuthorIdException(bookDTO.getAuthorId()));
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> taken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new InvalidBookIdException(id));

        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
