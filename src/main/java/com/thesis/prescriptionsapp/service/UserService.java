package com.thesis.prescriptionsapp.service;

import com.thesis.prescriptionsapp.domain.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
