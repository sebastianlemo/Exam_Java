package com.jhoanlemos.ideas.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.jhoanlemos.ideas.models.User;
import com.jhoanlemos.ideas.repositories.UserRepository;




@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public boolean save(User user) {
        String hashedPasswod = getHasPassword(user.getPassword());
        user.setPassword(hashedPasswod);
        return userRepository.save(user) != null;
    }

    private String getHasPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean emailDuplicated(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean invalidPassword(User user) {
        return  !user.getPassword().equals(user.getPasswordConfirmation());
    }

    public User login(String email, String password) {
        User user = findByemail(email);
        if (user!=null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            }
        }
        return  null;
    }

    private User findByemail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() ? user.get() : null;
    }

    public User finById(Long userId) {
        Optional<User> user =userRepository.findById(userId);
        return user.isPresent() ? user.get() : null;
    }
}
