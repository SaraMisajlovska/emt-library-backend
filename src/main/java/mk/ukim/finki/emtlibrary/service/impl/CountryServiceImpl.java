package mk.ukim.finki.emtlibrary.service.impl;

import mk.ukim.finki.emtlibrary.model.Country;
import mk.ukim.finki.emtlibrary.model.dto.CountryDTO;
import mk.ukim.finki.emtlibrary.model.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emtlibrary.repository.CountryRepository;
import mk.ukim.finki.emtlibrary.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {

        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository
                .findById(id)
                .orElseThrow(() -> new InvalidCountryIdException(id));
    }

    @Override
    public Optional<Country> save(CountryDTO countryDTO) {
        this.countryRepository.deleteByName(countryDTO.getName());
        return Optional.of(this.countryRepository.save(
                new Country(countryDTO.getName(),
                        countryDTO.getContinent())));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDTO countryDTO) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new InvalidCountryIdException(id));

        country.setName(countryDTO.getName());
        country.setContinent(countryDTO.getContinent());

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
