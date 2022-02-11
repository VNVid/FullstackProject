package toeatlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import toeatlist.services.UserService;
import toeatlist.tables.User;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{login:\\D+}")
    public User getUserById(@PathVariable("login") String login) {
        return userService.findByLogin(login);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/users/{userID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userID") Long id) {
        userService.delete(id);
    }
}
