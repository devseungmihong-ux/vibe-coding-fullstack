package com.example.vibeapp.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getPosts(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        int pageSize = 5;
        model.addAttribute("posts", postService.getPaginatedPosts(page, pageSize));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", postService.getTotalPages(pageSize));
        model.addAttribute("pageSize", pageSize);
        return "post/posts";
    }

    @GetMapping("/posts/{no}")
    public String getPost(@PathVariable("no") Long no, Model model) {
        model.addAttribute("post", postService.getPost(no));
        return "post/post_detail";
    }

    @GetMapping("/posts/new")
    public String newForm() {
        return "post/post_new_form";
    }

    @PostMapping("/posts/add")
    public String createPost(@RequestParam("title") String title, @RequestParam("content") String content) {
        postService.createPost(title, content);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{no}/edit")
    public String editForm(@PathVariable("no") Long no, Model model) {
        model.addAttribute("post", postService.getPost(no));
        return "post/post_edit_form";
    }

    @PostMapping("/posts/{no}/save")
    public String updatePost(@PathVariable("no") Long no, @RequestParam("title") String title,
            @RequestParam("content") String content) {
        postService.updatePost(no, title, content);
        return "redirect:/posts/" + no;
    }

    @GetMapping("/posts/{no}/delete")
    public String deletePost(@PathVariable("no") Long no) {
        postService.deletePost(no);
        return "redirect:/posts";
    }
}
