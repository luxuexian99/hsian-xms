package org.hsian.xms.services;

import org.hsian.xms.model.User;
import org.hsian.xms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hsian on 14-6-21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
