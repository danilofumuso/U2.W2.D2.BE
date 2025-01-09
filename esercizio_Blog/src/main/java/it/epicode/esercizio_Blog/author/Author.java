package it.epicode.esercizio_Blog.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.esercizio_Blog.post.Post;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

//    @OneToMany(mappedBy = "author")
//    @JsonIgnoreProperties({"author"})
//    private List<Post> posts = new ArrayList<>();

}
