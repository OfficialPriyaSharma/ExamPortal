package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    public User createUser(User user, Set<UserRole> userRole) throws Exception;
}
