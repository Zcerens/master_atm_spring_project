package org.example.atmdataproject.service;

import jakarta.transaction.Transactional;
import org.example.atmdataproject.entity.User;
import org.example.atmdataproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public Integer saveUser(User user) {
        user.setIsActive(1); //active code:1
        return userRepository.save(user).getId();
    }

    @Override
    @Transactional
    public void update(User user) {
        user.setIsActive(1);
        userRepository.save(user);

    }

    @Override
    @Transactional
    public User getOneUser(Integer id) {

        return userRepository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return userRepository.existsById(String.valueOf(id)) && getOneUser(id).getIsActive() == 1;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void userDeleted(User user) {
        user.setIsActive(0);
        userRepository.save(user);
    }
}
