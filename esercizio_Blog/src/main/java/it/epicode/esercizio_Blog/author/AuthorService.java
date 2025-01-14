package it.epicode.esercizio_Blog.author;


import it.epicode.esercizio_Blog.post.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Page<Author> findAll(Pageable pageable) {

        return authorRepository.findAll(pageable);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new EntityNotFoundException("autore non trovato!");
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
