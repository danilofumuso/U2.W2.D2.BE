package it.epicode.esercizio_Blog.post;

import it.epicode.esercizio_Blog.author.Author;
import it.epicode.esercizio_Blog.author.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorService authorService;

    //altro tipo di paginazione
//    public Page<Post> findAll(int page, int size, String sortBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return postRepository.findAll(pageable);
//    }

    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException("post non trovato!");
        }

        return postRepository.findById(id).get();
    }

    public Post createPost(PostDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);

        Author author = authorService.findById(postDTO.getAuthorId());

        post.setAuthor(author);

        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post modifiedPost) {
        Post post = findById(id);

        BeanUtils.copyProperties(modifiedPost, post);

        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
