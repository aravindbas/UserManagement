package com.techm.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.ums.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
