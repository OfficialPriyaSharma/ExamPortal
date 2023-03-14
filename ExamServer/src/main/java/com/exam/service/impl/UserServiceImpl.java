package com.exam.service.impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //    creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUserName(user.getUsername());
        if(local != null){
            System.out.println("User already present!!");
            throw new Exception("User exits !!");
        }
        else {
//            user create
            for(UserRole ur : userRoles)
            {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }
}
