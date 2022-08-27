package com.fdmgroup.com.SpringSoloProject;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("test")
public class TestMemberDetailsImpl implements UserDetailsService {
    public static final String API_USER = "apiuser@example.com";

    private User getAdminUser() {
		User user = new User(null, null, null);
        user.setUsername(API_USER);

        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_API_USER");
        user.setAuthorities(Collections.singletonList(role));

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) 
                                         throws UsernameNotFoundException {
        if (Objects.equals(username, ADMIN_USERNAME))
            return getAdminUser();
        throw new UsernameNotFoundException(username);
    }
}
