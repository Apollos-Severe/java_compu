package com.example.java_compu.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Remember the service layer is where we connect to our mock Sequlize ORM!
// And call on magic methods!
// Always Remember to instantiate the Repository/Sequlize layer
// Then inside the Controller Layer instantiate the service into the controller class!

@Service // This class is being injected into controller class
public class UserService {
    // A Service Needs a Repository
    private final UserRepository userRepository;

    @Autowired // Dependency injection on UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

}
