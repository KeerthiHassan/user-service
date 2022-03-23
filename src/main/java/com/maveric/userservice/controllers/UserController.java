package com.maveric.userservice.controllers;

import com.maveric.userservice.dto.UpdateUser;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.model.User;
import com.maveric.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUsersById(@PathVariable("userId") String userId){
        return new ResponseEntity<UserResponse>(userService.getUserDetails(userId), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser( @RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public  ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUser updateUser,@PathVariable("userId") String userId){
        return new ResponseEntity<UserResponse>(userService.updateUser(userId,updateUser),HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId){
        return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK) ;
    }




}
