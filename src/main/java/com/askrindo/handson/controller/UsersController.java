package com.askrindo.handson.controller;

import com.askrindo.handson.model.dto.ResponseData;
import com.askrindo.handson.model.entity.Role;
import com.askrindo.handson.model.entity.User;
import com.askrindo.handson.service.impl.UsersServiceImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersServiceImpl usersService;

    @PostMapping("/user/register")
    public ResponseEntity<ResponseData<User>> register(@Valid @RequestBody User user, Errors errors) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/register").toUriString());
        ResponseData<User> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.getMessages().add("Success");
        responseData.setData(usersService.saveUser(user));
        return ResponseEntity.created(uri).body(responseData);
    }

    @PostMapping("/role/save")
    public ResponseEntity<ResponseData<Role>> save(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        ResponseData<Role> responseData = new ResponseData<>();
        responseData.getMessages().add("Success");
        responseData.setData(usersService.saveRole(role));
        return ResponseEntity.created(uri).body(responseData);
    }

    @PostMapping("/role/add-to-user")
    public ResponseEntity<ResponseData<User>> addRoleToUser(@RequestBody RoleToUserForm form) {
        ResponseData<User> responseData = new ResponseData<>();
        User user = usersService.addRoleToUser(form.getUsername(), form.getRoleName());
        log.info("Form data: {} {}", form.getUsername(), form.getRoleName());
        if (user == null) {
            responseData.getMessages().add("User " + form.getUsername() + " or Role " + form.getRoleName() + " not found");
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.getMessages().add("Success");
        responseData.setData(user);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/user")
    public ResponseEntity<ResponseData<List<User>>> findAll() {
        ResponseData<List<User>> responseData = new ResponseData<>();
        responseData.getMessages().add("Success");
        responseData.setData(usersService.getUsers());
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseData<User>> findById(@PathVariable("id") String id) {
        ResponseData<User> responseData = new ResponseData<>();
        User user = usersService.getUserById(id);
        if (user == null) {
            responseData.getMessages().add("User with value ID " + id + " not found");
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.getMessages().add("Success");
        responseData.setData(user);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/user")
    public ResponseEntity<ResponseData<User>> update(@Valid @RequestBody User user, Errors errors, HttpServletRequest request) {
        ResponseData<User> responseData = new ResponseData<>();
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String token = authorizationHeader.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        stream(roles).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
        SimpleGrantedAuthority superAdmin = new SimpleGrantedAuthority("ROLE_SUPER_ADMIN");

        if (!Objects.equals(user.getUsername(), username) && (!authorities.contains(admin) || !authorities.contains(superAdmin))){
            responseData.getMessages().add("You are not allowed to update other users data.");
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        }

        User updateUser = usersService.updateUser(user);
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        } else if (updateUser == null) {
            responseData.getMessages().add("User with value ID " + user.getId() + " not found");
            responseData.setData(null);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.getMessages().add("Success");
        responseData.setData(updateUser);
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ResponseData<Integer>> removeOne(@PathVariable("id") String id) {
        ResponseData<Integer> responseData = new ResponseData<>();
        Boolean deleted = usersService.deleteUser(id);
        if (!deleted) {
            responseData.getMessages().add("User with value ID " + id + " not found");
            responseData.setData(0);
            return ResponseEntity.badRequest().body(responseData);
        }
        responseData.getMessages().add("User with value ID " + id + " was deleted successfully");
        responseData.setData(1);
        return ResponseEntity.ok(responseData);
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
