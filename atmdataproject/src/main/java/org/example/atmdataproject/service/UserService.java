package org.example.atmdataproject.service;

import org.example.atmdataproject.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public Integer saveUser(User user);


    public void update(User user);

    public User getOneUser(Integer id);

    public boolean isAvailable(Integer id);

    public List<User> findAll();

    public void userDeleted(User user);
}
