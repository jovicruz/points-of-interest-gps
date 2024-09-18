package com.jovicruz.points_of_interest.repositories;

import com.jovicruz.points_of_interest.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);

    boolean existsByLogin(String login);
}
