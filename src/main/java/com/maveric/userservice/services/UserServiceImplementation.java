package com.maveric.userservice.services;

import com.maveric.userservice.dto.PostResponse;
import com.maveric.userservice.dto.UpdateUser;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.feign.Feign;
import com.maveric.userservice.model.Comment;
import com.maveric.userservice.model.Post;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    Feign feign;






    @Override
    public UserResponse updateUser(String userId, UpdateUser updateUser) {
        User user=userRepo.findByuserId(userId);
        user.setFirstName(updateUser.getFirstName());
        user.setMiddleName(updateUser.getMiddleName());
        user.setLastName(updateUser.getLastName());
        user.setPhoneNumber(updateUser.getPhoneNumber());
        user.setDateOfBirth(updateUser.getDateOfBirth());
        user.setBloodGroup(updateUser.getBloodGroup());
        user.setEmail(updateUser.getEmail());
        user.setEmployeeNumber(updateUser.getEmployeeNumber());
        user.setMaritalStatus(updateUser.getMaritalStatus());
        user.setGender(updateUser.getGender());
        user.setPassword(updateUser.getPassword());
        user=userRepo.save(user);
        UserResponse userResponse=new UserResponse();

        userResponse.setUserId(user.getUserId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setMiddleName(user.getMiddleName());
        userResponse.setLastName(user.getLastName());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setEmployeeNumber(user.getEmployeeNumber());
        userResponse.setGender(user.getGender());
        userResponse.setMaritalStatus(user.getMaritalStatus());
        userResponse.setBloodGroup(user.getBloodGroup());
        userResponse.setEmail(user.getEmail());
        return userResponse;

    }
    @Override
    public String deleteUser(String userId) {
        userRepo.deleteById(userId);
        return "User successfully deleted";
    }

}
