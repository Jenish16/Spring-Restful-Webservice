package com.jen.webservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jen.webservice.user.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}