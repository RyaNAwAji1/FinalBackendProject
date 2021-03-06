package com.example.technicalworkshop.Service;

import com.example.technicalworkshop.Model.User;
import com.example.technicalworkshop.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository){
        this.userRepository =userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findUsersByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }

        return user;
    }

}
