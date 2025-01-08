package it.epicode.esercizio_Blog.author;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String surname;

    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String avatar;

}
