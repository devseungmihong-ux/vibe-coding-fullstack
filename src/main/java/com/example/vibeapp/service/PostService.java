package com.example.vibeapp.service;

import com.example.vibeapp.domain.Post;
import com.example.vibeapp.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            postRepository.save(new Post(
                (long) i,
                "Example Post " + i,
                "This is the content for example post " + i,
                LocalDateTime.now().minusDays(10 - i),
                LocalDateTime.now().minusDays(10 - i),
                i * 10
            ));
        }
    }

    public Post getPost(Long no) {
        Post post = postRepository.findByNo(no)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post number: " + no));
        post.setViews(post.getViews() + 1);
        return post;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll().stream()
                .sorted(java.util.Comparator.comparingLong(Post::getNo).reversed())
                .toList();
    }

    public void addPost(String title, String content) {
        long nextNo = postRepository.findAll().stream()
                .mapToLong(Post::getNo)
                .max()
                .orElse(0L) + 1;

        Post post = new Post();
        post.setNo(nextNo);
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(java.time.LocalDateTime.now());
        post.setUpdatedAt(null);
        post.setViews(0);

        postRepository.save(post);
    }
}
