package com.shpc.schoolapp.repository;

import com.shpc.schoolapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {
    List<Comment> findByNewid(String newid);
}
