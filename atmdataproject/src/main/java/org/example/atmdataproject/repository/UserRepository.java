package org.example.atmdataproject.repository;

import org.example.atmdataproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}

