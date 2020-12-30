package com.project.omss.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.omss.entity.User;

public interface UserJpaRepository extends CrudRepository<User, Integer>{

}
