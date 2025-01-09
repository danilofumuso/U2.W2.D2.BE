package it.epicode.esercizio_Blog.post;

import it.epicode.esercizio_Blog.author.Author;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String category;

    private String title;

    private String cover;

    private String content;

    @Column(name = "reading_time")
    private int readingTime;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

}
