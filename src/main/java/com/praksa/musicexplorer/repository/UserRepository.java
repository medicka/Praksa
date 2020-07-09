package com.praksa.musicexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praksa.musicexplorer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
