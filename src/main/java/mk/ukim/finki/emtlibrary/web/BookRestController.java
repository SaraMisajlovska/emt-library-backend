package mk.ukim.finki.emtlibrary.web;

import mk.ukim.finki.emtlibrary.model.Book;
import mk.ukim.finki.emtlibrary.model.dto.BookDTO;
import mk.ukim.finki.emtlibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping({"/api/books", "/"})
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDTO bookDTO) {
        return this.bookService.save(bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,
                                     @RequestBody BookDTO bookDTO) {
        return this.bookService.edit(id, bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }
    @PutMapping("/markTaken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id) {
        return this.bookService.taken(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);

        return this.bookService.findById(id).isEmpty() ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
