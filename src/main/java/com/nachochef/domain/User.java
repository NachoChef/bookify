package com.nachochef.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_created", nullable = false)
    private String dateCreated;

    /**
     * for new users, man
     */
    public User(String username, String name, String email, String dateCreated) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.dateCreated = dateCreated;
    }
}
