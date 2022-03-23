package com.maveric.userservice.services;


import com.maveric.userservice.dto.UpdateUser;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService {

    UserResponse updateUser(String userId, UpdateUser updateUser);
    String deleteUser(String userId);
}
