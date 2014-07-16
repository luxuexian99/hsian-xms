/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.hsian.xms.repositories.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.hsian.xms.model.User;

import java.util.Date;

import static org.hsian.xms.repositories.common.BasSqlMapper.addUserSql;

/**
 * org.hsian.xms.repositories.mapper
 * Created by Hsian on 14-7-12.
 */
public interface UserMapper {

    @Insert(
        value = {
            " insert into t_bas_user(name, email, password, createdTime, creatorId, lockVersion, statusId) ",
            " values (#{userName}, #{email}, #{password}, #{createdTime}, 0, #{lockVersion}, 0) "
        }
    )
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int addUser(User user);

}
