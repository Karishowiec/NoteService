package org.example.controller;


import org.example.model.User;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.create(user));
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("user", userService.findAll());
        return "user-list";
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return this.userService.findByName(username);
    }

    @DeleteMapping("/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
         this.userService.deleteByName(username);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User user) {
        if (!this.userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        return ResponseEntity.ok(this.userService.update(user));
    }
}
