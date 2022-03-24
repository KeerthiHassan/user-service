package com.maveric.userservice.controllers;

import com.maveric.userservice.dto.Userdto;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.model.User;
import com.maveric.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(){
        return new ResponseEntity<List<UserResponse>>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody Userdto user){
        return new ResponseEntity<UserResponse>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUsersById(@PathVariable("userId") String userId){
        return new ResponseEntity<UserResponse>(userService.getUserDetails(userId), HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public  ResponseEntity<UserResponse> updateUser(@Valid @RequestBody Userdto updateUser, @PathVariable("userId") String userId){
        return new ResponseEntity<UserResponse>(userService.updateUser(userId,updateUser),HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId){
        return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK) ;
    }
    @GetMapping("/users/getUserByEmail/{emailId}")
    public ResponseEntity<UserResponse> getUserDetailsByEmail(@PathVariable("emailId") String emailId){
        return new ResponseEntity<UserResponse>(userService.getUserDetailsByEmail(emailId), HttpStatus.OK);
    }

}
