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
        user.setIsActive(true); //active code:1
        return userRepository.save(user).getId();
    }

    @Override
    @Transactional
    public void update(User user) {
        user.setIsActive(true);
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
        return userRepository.existsById(String.valueOf(id)) && getOneUser(id).isActive() == true;
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<User> findByIsActive(boolean isActive) {
        return userRepository.findByIsActive(isActive);
    }


    @Override
    public void userDeleted(User user) {

        String userIdAsString = Integer.toString(user.getId());
        User existingUser = userRepository.findById(userIdAsString).orElse(null);

        if (existingUser != null) {
            // Mevcut kullanıcıyı inaktif yap ve kaydet
            existingUser.setIsActive(false);
            userRepository.save(existingUser);
        }
    }


    @Transactional
    public List<User> findByIsActiveTrue() {
        return userRepository.findByIsActiveTrue();
    }
}
