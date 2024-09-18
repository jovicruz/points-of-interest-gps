package com.jovicruz.points_of_interest.services;


import com.jovicruz.points_of_interest.domain.user.User;
import com.jovicruz.points_of_interest.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class authService implements UserDetailsService {

    @Autowired
    userRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByLogin(username);
    }

    public boolean checkIfExists(String login){
        return repo.existsByLogin(login);
    }

    public void createNewUser(User newuser){
        repo.save(newuser);
    }


}
