package com.projectps.cinema.controller;

import com.projectps.cinema.DTO.UserDTO;
import com.projectps.cinema.entity.User;
import com.projectps.cinema.service.MovieService;
import com.projectps.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<UserDTO> usersDTO) {
        return userService.saveUsers(usersDTO);
    }

    @GetMapping("/allUsers")
    public List<UserDTO> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/byId/{id}")
    public UserDTO findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/addMovieToFavoriteList/{userId}/{movieId}")
    public UserDTO addMovieToFavorite(@PathVariable int userId, @PathVariable int movieId) {
        userService.addMovieToFavoritesList(userId, movieId);
        return userService.getUserById(userId);
    }

    @DeleteMapping("/removeMovieFromFavoriteList/{userId}/{movieId}")
    public UserDTO removeMovieFromFavorite(@PathVariable int userId, @PathVariable int movieId) {
        userService.removeMovieFromFavoritesList(userId, movieId);
        return userService.getUserById(userId);
    }

    @PostMapping("/addMovieToWatchList/{userId}/{movieId}")
    public UserDTO addMovieToWatchList(@PathVariable int userId, @PathVariable int movieId) {
        userService.addMovieToWatchList(userId, movieId);
        movieService.incresePopularity(movieId);
        return userService.getUserById(userId);
    }

    @DeleteMapping("/removeMovieFromWatchList/{userId}/{movieId}")
    public UserDTO removeMovieFromWatchList(@PathVariable int userId, @PathVariable int movieId) {
        userService.removeMovieFromWatchList(userId, movieId);
        movieService.decreasePopularity(movieId);
        return userService.getUserById(userId);
    }
}
