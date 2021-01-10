package com.jen.webservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jen.webservice.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}