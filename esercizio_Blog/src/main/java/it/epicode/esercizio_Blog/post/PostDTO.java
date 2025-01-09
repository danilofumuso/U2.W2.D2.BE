package it.epicode.esercizio_Blog.post;

import lombok.Data;

@Data
public class PostDTO {

    private String title;

    private String content;

    private int readingTime;

    private Long authorId;
}
