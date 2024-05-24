package org.example.atmdataproject.repository;

import org.example.atmdataproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    List<User> findByIsActiveTrue();
    List<User> findByIsActive(boolean isActive);
}

