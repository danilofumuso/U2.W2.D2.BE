package it.epicode.esercizio_Blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    //altro tipo di paginazione
//    @GetMapping("/paged")
//    public ResponseEntity<Page<Post>> getAllBlogPosts(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sortBy) {
//        return ResponseEntity.ok(postService.findAll(page, size, sortBy));
//    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Post>> findAllPosts(Pageable pageable) {
        return ResponseEntity.ok(postService.findAll(pageable));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){

        List<Post> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post modifiedPost) {
        return ResponseEntity.ok(postService.updatePost(id, modifiedPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
      postService.deletePost(id);
      return new ResponseEntity<>("Post eliminato correttamente!", HttpStatus.NO_CONTENT);
    }
}
