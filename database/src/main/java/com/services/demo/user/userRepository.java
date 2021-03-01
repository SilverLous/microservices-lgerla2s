package com.services.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    @Query("Select u FROM User u WHERE u.userName=?1")
    Optional<User> findUserByUserName(String userName);

}
