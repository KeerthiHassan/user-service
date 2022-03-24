package com.maveric.userservice.services;

import com.maveric.userservice.dto.Userdto;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.enums.Gender;
import com.maveric.userservice.exception.UserDetailsNotPresent;
import com.maveric.userservice.exception.UserNotExistsException;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserResponse createUser(Userdto userdto) {
        User user=new User();

        user.setFirstName(userdto.getFirstName());
        user.setMiddleName(userdto.getMiddleName());
        user.setLastName(userdto.getLastName());
        user.setPhoneNumber(userdto.getPhoneNumber());
        user.setDateOfBirth(userdto.getDateOfBirth());
        user.setBloodGroup(userdto.getBloodGroup());
        user.setEmail(userdto.getEmail());
        user.setEmployeeNumber(userdto.getEmployeeNumber());
        user.setAddress(userdto.getAddress());
        user.setGender(userdto.getGender());
        String encriptedPasswd=bCryptPasswordEncoder.encode(userdto.getPassword());
        user.setPassword(encriptedPasswd);
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
        userResponse.setAddress(user.getAddress());
        userResponse.setBloodGroup(user.getBloodGroup());
        userResponse.setEmail(user.getEmail());
        return userResponse;

    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> userList=userRepo.findAll();
        List<UserResponse> userResponseList=new ArrayList<>();
        if(userList.size()==0){
            throw new UserDetailsNotPresent("No User Present at this time");
        }

        for(User user:userList){
            userResponseList.add(new UserResponse(user.getUserId(),user.getFirstName(),user.getMiddleName(),
                    user.getLastName(),user.getPhoneNumber(),user.getDateOfBirth(),user.getGender(),
                    user.getAddress(),user.getEmployeeNumber(),user.getBloodGroup(),user.getEmail()));
        }
        return userResponseList;
    }

    @Override
    public UserResponse getUserDetails(String userId) {
    UserResponse userResponse=new UserResponse();

    User user=userRepo.findByuserId(userId);
        if (user == null)
            throw new UserNotExistsException("User with id not Present");
    userResponse.setUserId(user.getUserId());
    userResponse.setFirstName(user.getFirstName());
    userResponse.setMiddleName(user.getMiddleName());
    userResponse.setLastName(user.getLastName());
    userResponse.setPhoneNumber(user.getPhoneNumber());
    userResponse.setDateOfBirth(user.getDateOfBirth());
    userResponse.setEmployeeNumber(user.getEmployeeNumber());
    userResponse.setGender(user.getGender());
    userResponse.setAddress(user.getAddress());
    userResponse.setBloodGroup(user.getBloodGroup());
    userResponse.setEmail(user.getEmail());
    return userResponse;
    }

    @Override
    public UserResponse updateUser(String userId, Userdto updateUser) {
        User user=userRepo.findByuserId(userId);
        user.setFirstName(updateUser.getFirstName());
        user.setMiddleName(updateUser.getMiddleName());
        user.setLastName(updateUser.getLastName());
        user.setPhoneNumber(updateUser.getPhoneNumber());
        user.setDateOfBirth(updateUser.getDateOfBirth());
        user.setBloodGroup(updateUser.getBloodGroup());
        user.setEmail(updateUser.getEmail());
        user.setEmployeeNumber(updateUser.getEmployeeNumber());
        user.setAddress(updateUser.getAddress());
        user.setGender(updateUser.getGender());
        String encriptedPasswd=bCryptPasswordEncoder.encode(updateUser.getPassword());
        user.setPassword(encriptedPasswd);
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
        userResponse.setAddress(user.getAddress());
        userResponse.setBloodGroup(user.getBloodGroup());
        userResponse.setEmail(user.getEmail());
        return userResponse;

    }

    @Override
    public String deleteUser(String userId) {
        User user=userRepo.findByuserId(userId);
        if(user==null)
            throw new UserNotExistsException("User cannot be deleted, user not Present");
         userRepo.deleteById(userId);
         return "User successfully deleted";
    }

    @Override
    public UserResponse getUserDetailsByEmail(String emailId) {
        User user=userRepo.findByemail(emailId);
        return new UserResponse(user.getUserId(),user.getFirstName(),user.getMiddleName(),
                user.getLastName(),user.getPhoneNumber(),user.getDateOfBirth(),user.getGender(),
                user.getAddress(),user.getEmployeeNumber(),user.getBloodGroup(),user.getEmail());
    }
}
