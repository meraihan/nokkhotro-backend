package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.AuthenticatedUser;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Role;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.User;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Utils {
    public static Set<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName().name())));
        return authorities;
    }

    public static Integer getCurrentLogedInUserId() {
        return ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}
