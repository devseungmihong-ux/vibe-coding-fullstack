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

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
