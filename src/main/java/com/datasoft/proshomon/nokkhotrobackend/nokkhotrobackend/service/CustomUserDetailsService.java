package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.AuthenticatedUser;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.User;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.UserRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.UsersRolesRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.security.UserPrincipal;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName : " + userName + "Not Found");
        }
        Set<GrantedAuthority> authority = Utils.mapRolesToAuthorities(usersRolesRepository.resolveRolesForUser(user));
        user.setGrantedAuthorities(new ArrayList<>(authority));
        return UserPrincipal.create(user);
    }


    public UserDetails loadUserById(Long userId) {
        User user = userRepository.findUserByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with id : " + userId);
        }
        Set<GrantedAuthority> authority = Utils.mapRolesToAuthorities(usersRolesRepository.resolveRolesForUser(user));
        user.setGrantedAuthorities(new ArrayList<>(authority));
        return UserPrincipal.create(user);
    }
}
