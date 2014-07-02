package org.hsian.xms.repositories;

import org.hsian.xms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * User 访问数据库的实现。
 * Created by Hsian on 14-6-21.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    DataSource dataSource;

    @Override
    public User addUser(User user) {
        Connection connection = null;
        String sql =
                "insert into t_bas_user(name, email, password, createdTime, creatorId, lockVersion, statusId) " +
                " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setObject(4, new Date());
            pstmt.setLong(5, 0);
            pstmt.setLong(6, 0);
            pstmt.setLong(7, 1);

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
