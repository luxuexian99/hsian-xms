package org.hsian.xms.services;

import org.hsian.xms.model.User;

/**
 * User业务逻辑层
 * Created by Hsian on 14-6-21.
 */
public interface UserService {
    User addUser(User user);
    void delete(User user);
}
