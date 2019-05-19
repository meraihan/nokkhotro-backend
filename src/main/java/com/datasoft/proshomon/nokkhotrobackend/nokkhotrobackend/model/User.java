package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private String phone;
    private String email;
//    private List<UserRoles> authorities;
    List<GrantedAuthority> grantedAuthorities;
    private LocalDateTime lastPasswordResetDate;
    private Boolean isEnabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
