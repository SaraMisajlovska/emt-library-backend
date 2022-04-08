package mk.ukim.finki.emtlibrary.web;

import mk.ukim.finki.emtlibrary.model.Author;
import mk.ukim.finki.emtlibrary.model.Country;
import mk.ukim.finki.emtlibrary.service.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("https://library-frontend-191517.herokuapp.com")
@RequestMapping("/api/country")
public class CountryRestController {
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> findAll() {
        return this.countryService.findAll();
    }
}
