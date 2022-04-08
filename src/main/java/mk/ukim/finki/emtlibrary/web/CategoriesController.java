package mk.ukim.finki.emtlibrary.web;

import mk.ukim.finki.emtlibrary.model.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin("https://library-frontend-191517.herokuapp.com")
@RequestMapping("/api/categories")
public class CategoriesController {

    @GetMapping
    public List<String> getCategories(){
        return Stream.of(Category.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
