/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.hsian.xms.repositories.sql;

import org.hsian.xms.model.User;

/**
 * 存放user相关的sql的地方。
 * org.hsian.xms.repositories.sql
 * Created by Hsian on 14-8-9.
 */
public class UserSqlBuilder extends SQLTemplate<User> {

    /** 插入user记录的sqlMapper语句 */
    public static final String addUserSql =
        " insert into t_bas_user(name, email, password, createdTime, creatorId, lockVersion, statusId) " +
        " values (#{userName}, #{email}, #{password}, #{createdTime}, 0, #{lockVersion}, 0) ";

}
