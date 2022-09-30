package com.askrindo.handson.service;

import com.askrindo.handson.model.entity.Role;
import com.askrindo.handson.model.entity.User;

import java.util.List;

public interface UsersService {
    User saveUser(User user);
    User updateUser(User user);
    Role saveRole(Role role);
    User addRoleToUser(String username, String roleName);
    User getUser(String username);
    Role getRole(String name);
    User getUserById(String id);
    List<User> getUsers();
    Boolean deleteUser(String id);
}
