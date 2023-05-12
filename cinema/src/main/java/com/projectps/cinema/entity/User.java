package com.projectps.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "isAdmin cannot be null")
    private boolean isAdmin;

    @NotNull(message = "name cannot be empty")
    private String name;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "username cannot be null")
    private String username;

    @NotNull(message = "password cannot be null")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @JsonIgnoreProperties("users")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "fmovie_user",
            joinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            })
    private List<Movie> favoriteMovies;

    @JsonIgnoreProperties("users")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "wmovie_user",
            joinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            })
    private List<Movie> watchList;

    private ZonedDateTime lastLogin;
}
