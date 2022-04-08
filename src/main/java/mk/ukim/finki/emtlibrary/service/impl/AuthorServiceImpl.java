package mk.ukim.finki.emtlibrary.service.impl;

import mk.ukim.finki.emtlibrary.model.Author;
import mk.ukim.finki.emtlibrary.model.Country;
import mk.ukim.finki.emtlibrary.model.dto.AuthorDTO;
import mk.ukim.finki.emtlibrary.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.emtlibrary.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emtlibrary.repository.AuthorRepository;
import mk.ukim.finki.emtlibrary.repository.CountryRepository;
import mk.ukim.finki.emtlibrary.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;

    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository
                .findById(id)
                .orElseThrow(() -> new InvalidAuthorIdException(id));
    }

    @Override
    @Transactional
    public Optional<Author> save(AuthorDTO authorDTO) {
        Country country = this.countryRepository
                .findById(authorDTO.getCountry().getId())
                .orElseThrow(() -> new InvalidCountryIdException(authorDTO.getCountry().getId()));

        authorRepository.deleteByName(authorDTO.getName());

        Author author = new Author(authorDTO.getName(),
                authorDTO.getSurname(),
                country);

        return Optional.of(this.authorRepository.save(author));

    }

    @Override
    public Optional<Author> edit(Long id, AuthorDTO authorDTO) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new InvalidAuthorIdException(id));
        Country country = this.countryRepository
                .findById(authorDTO.getCountry().getId())
                .orElseThrow(() -> new InvalidCountryIdException(authorDTO.getCountry().getId()));

        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setCountry(country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
