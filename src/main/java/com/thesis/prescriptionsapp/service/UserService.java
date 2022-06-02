package com.thesis.prescriptionsapp.service;

import com.thesis.prescriptionsapp.domain.Role;
import com.thesis.prescriptionsapp.domain.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
