package com.evins.blog.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evins.blog.demo.repositories.BlogRepository;
import com.evins.blog.demo.entities.Blog;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BlogController {
    // property to hold blog repository
    public BlogRepository Blogs;

    public BlogController(BlogRepository Blogs) {
        this.Blogs = Blogs;
    }

    // get request to / Blogs
    @CrossOrigin
    @GetMapping("/blogs")
    public List<Blog> index() {
        return Blogs.findAll();
    }

    // get request to /Blogs/:id
    @CrossOrigin
    @GetMapping("/blogs/{id}")
    public Optional<Blog> show(@PathVariable Integer id) {
        return Blogs.findById(id);
    }

    @CrossOrigin
    @PostMapping("/blogs")
    public List<Blog> create(@RequestBody Blog newBlog) {
        Blogs.save(newBlog);
        return Blogs.findAll();
    }

    @CrossOrigin
    @PutMapping("/blogs/{id}")
    public List<Blog> update(@RequestBody Blog fixBlog, @PathVariable Integer id) {
        Blogs.findById(id).map(Blog -> {

            Blog.setSubject(fixBlog.getSubject());
            Blog.setDetails(fixBlog.getDetails());
            return Blog;
        });

        // return all Blogs
        return Blogs.findAll();
    }

}
