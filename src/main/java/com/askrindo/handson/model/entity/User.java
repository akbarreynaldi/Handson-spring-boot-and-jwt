package com.askrindo.handson.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "username is required")
    @Column(length = 20, nullable = false, unique = true)
    private String username;
    @NotEmpty(message = "password is required")
    @Column(length = 100, nullable = false)
    private String password;
    @NotEmpty(message = "address is required")
    private String address;
    @Column(length = 16, nullable = false, unique = true)
    private String NIK;
    @Column(length = 16, nullable = false, unique = true)
    private String NPWP;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
}