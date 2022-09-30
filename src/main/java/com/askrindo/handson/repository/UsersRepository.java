package com.askrindo.handson.repository;

import com.askrindo.handson.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);
}
