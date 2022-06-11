package com.example.technicalworkshop.Repository;

import com.example.technicalworkshop.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Integer> {
    User findUsersByUsername(String name);
}
