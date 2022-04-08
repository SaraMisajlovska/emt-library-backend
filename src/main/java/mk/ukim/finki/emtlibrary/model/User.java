package mk.ukim.finki.emtlibrary.model;

import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.emtlibrary.model.enums.Role;

@Data
@Entity
@Table(name = "library_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String username;
    private String password;
    private Role role;

}
