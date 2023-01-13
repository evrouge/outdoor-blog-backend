package com.evins.blog.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evins.blog.demo.entities.Blog;

// repository two types in <> are entity and type of id
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
