package org.example.controller;

import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = GET)
    @GetMapping
    public UserDto getUser(@PathVariable("id") Long id) {
        UserDto response = userService.getById(id);

        return response;
    }

    @PostMapping
    public UserDto add(@RequestBody UserDto user) {
        UserDto response = userService.create(user);

        return response;
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @DeleteMapping
    public UserDto deleteUser(@PathVariable("id") Long id) {
        UserDto deleteUser = userService.delete(id);

        return deleteUser;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @PutMapping
    public UserDto putUser(@RequestBody UserDto updateUser) {
        UserDto response = userService.update(updateUser);

        return response;
    }
}
