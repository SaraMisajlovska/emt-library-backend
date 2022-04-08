package mk.ukim.finki.emtlibrary.service;

import mk.ukim.finki.emtlibrary.model.Country;
import mk.ukim.finki.emtlibrary.model.dto.CountryDTO;

import java.util.List;
import java.util.Optional;


public interface CountryService {

    List<Country> findAll();

    Country findById(Long id);

    Optional<Country> save(CountryDTO countryDTO);

    Optional<Country> edit(Long id, CountryDTO countryDTO);

    void deleteById(Long id);
}
