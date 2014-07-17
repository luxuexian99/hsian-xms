package org.hsian.xms.repositories;

import org.hsian.xms.model.User;

/**
 *
 * Created by Hsian on 14-6-21.
 */
public interface UserRepository {
    User addUser(User user);
    void delete(User user);
}
