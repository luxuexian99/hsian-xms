package org.hsian.xms.repositories;

import org.hsian.xms.model.User;
import org.hsian.xms.repositories.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

import static org.slf4j.LoggerFactory.*;

/**
 * User 访问数据库的实现。
 * Created by Hsian on 14-6-21.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Logger logger = getLogger(UserRepositoryImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        logger.info("addUser:" + user);
        user.setCreatedTime(new Date());
        int effective = userMapper.addUser(user);

        if(effective != 1) {
            logger.error("effective error!");
//            throw new Exception();
        }
        logger.info("addUser");
        return user;
    }

    @Override
    public void delete(User user) {
        userMapper.delete(user);
    }
}
