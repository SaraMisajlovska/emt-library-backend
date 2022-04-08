package mk.ukim.finki.emtlibrary.service;

import mk.ukim.finki.emtlibrary.model.Author;
import mk.ukim.finki.emtlibrary.model.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Long id);

    Optional<Author> save(AuthorDTO authorDTO);

    Optional<Author> edit(Long id, AuthorDTO authorDTO);

    void deleteById(Long id);
}
