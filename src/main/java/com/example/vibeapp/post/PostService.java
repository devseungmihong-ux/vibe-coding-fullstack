package com.example.vibeapp.post;

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
                    i * 10));
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

    public List<Post> getPaginatedPosts(int page, int size) {
        List<Post> allPosts = getAllPosts();
        int fromIndex = (page - 1) * size;
        if (fromIndex >= allPosts.size()) {
            return List.of();
        }
        int toIndex = Math.min(fromIndex + size, allPosts.size());
        return allPosts.subList(fromIndex, toIndex);
    }

    public int getTotalPages(int size) {
        int totalPosts = postRepository.findAll().size();
        if (totalPosts == 0)
            return 1;
        return (int) Math.ceil((double) totalPosts / size);
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

    public void updatePost(Long no, String title, String content) {
        Post post = getPost(no);
        post.setTitle(title);
        post.setContent(content);
        post.setUpdatedAt(LocalDateTime.now());
    }

    public void deletePost(Long no) {
        postRepository.deleteByNo(no);
    }
}
