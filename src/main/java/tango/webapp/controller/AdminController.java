package tango.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tango.webapp.model.User;
import tango.webapp.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminLogin () {
        return "admin";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, consumes = MediaType.ALL_VALUE)
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId);
        user.setPaymentConfirmation(userDetails.getPaymentConfirmation());
        user = userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId);
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
