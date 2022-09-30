package com.askrindo.handson.service.impl;

import com.askrindo.handson.model.entity.Role;
import com.askrindo.handson.model.entity.User;
import com.askrindo.handson.repository.RoleRepository;
import com.askrindo.handson.repository.UsersRepository;
import com.askrindo.handson.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsersServiceImpl implements UsersService, UserDetailsService {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found in database");
        } else {
            log.info("User found in database: '{}'", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        assert user != null;
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user '{}' to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
        public User updateUser(User user) {
        log.info("Updating new user '{}' to the database", user.getName());
        Optional<User> id = usersRepository.findById(user.getId());
        if (!id.isPresent()) {
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role '{}' to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public User addRoleToUser(String username, String roleName) {
        log.info("Adding role '{}' to user '{}'", roleName, username);
        User user = usersRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        if (role == null || user == null) {
            return null;
        }
        user.getRoles().add(role);
        return usersRepository.findByUsername(username);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user '{}'", username);
        return usersRepository.findByUsername(username);
    }

    @Override
    public User getUserById(String id) {
        log.info("Fetching user by id '{}'", id);
        Optional<User> user = usersRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return usersRepository.findAll();
    }

    @Override
    public Boolean deleteUser(String id) {
        log.info("Delete user by id '{}'", id);
        Optional<User> user = usersRepository.findById(id);
        if (!user.isPresent()) {
            return false;
        }
        usersRepository.deleteById(id);
        return true;
    }
}
