package org.hsian.xms.repositories;

import org.hsian.xms.model.User;
import org.hsian.xms.repositories.common.BasSqlMapper;
import org.hsian.xms.repositories.common.RepositoryTemplate;
import org.hsian.xms.repositories.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static org.hsian.xms.repositories.common.BasSqlMapper.*;

/**
 * User 访问数据库的实现。
 * Created by Hsian on 14-6-21.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {

        user.setCreatedTime(new Date());
        int effective = userMapper.addUser(user);

        if(effective != 1) {
//            throw new Exception();
        }

        return user;
    }
}
