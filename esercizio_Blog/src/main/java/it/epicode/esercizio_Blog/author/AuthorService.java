package it.epicode.esercizio_Blog.author;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new IllegalArgumentException("autore non trovato!");
        }

        return authorRepository.findById(id).get();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id,Author modifiedAuthor) {
        Author author = findById(id);

        BeanUtils.copyProperties(modifiedAuthor,author);

        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
