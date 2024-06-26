package org.sai.samithi.controllers;

import org.sai.samithi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post")
    public String postsPage(@RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("postPage",
                postService.postPageRequest(page, 12));
        return "posts/index";
    }

    @GetMapping("/post/list")
    public String getPosts(@RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("postPage",
                postService.postPageRequest(page, 15));
        return "posts/list";
    }

    @GetMapping("/post/{path}")
    public String getPost(@PathVariable("path") String path) {
        return "posts/" + path;
    }

}
