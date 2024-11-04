package ru.lada.nauJava.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.lada.nauJava.objects.Role;
import ru.lada.nauJava.objects.User;
import ru.lada.nauJava.services.UserServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserServiceImpl users ;

    public MyUserDetailService(){
        User user = new User();
        user.setUsername("USER");
        user.setPassword("USER");
        user.setRole(Role.USER);
        User admin = new User();
        admin.setUsername("ADMIN");
        admin.setPassword("ADMIN");
        admin.setRole(Role.ADMIN);
        try{
        users.createUser(user);
        users.createUser(admin);
        }
        catch(Exception e){

        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username).stream().findFirst().orElse(null);
        if(user != null){
            ArrayList<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().name()));
            org.springframework.security.core.userdetails.User appUser = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), roles);
            return appUser;
        }
        else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
