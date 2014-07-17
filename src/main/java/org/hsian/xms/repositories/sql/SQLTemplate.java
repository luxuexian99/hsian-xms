/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.hsian.xms.repositories.sql;

import org.apache.ibatis.jdbc.SQL;
import org.hsian.xms.model.common.AbstractPo;

public class SQLTemplate<T extends AbstractPo> {

    private static final String tableAliasName = " o ";

    /**
     * 根据Id删除po，因为需要po中的tableName，故，传带有Id的po对象。
     * @param po
     * @return
     */
    public String delete(T po) {
        SQL sql = new SQL();
        sql.DELETE_FROM(po.table())
           .WHERE(po.id() + "=#{" + po.id() + "}");
        return sql.toString();
    }

    /**
     * 根据Id获取po，因为需要po中的tableName，故，传带有Id的po对象。
     * @param po
     * @return
     */
    public String get(T po) {
        SQL sql = new SQL();
        sql.SELECT("o.*")
           .FROM(po.table() + tableAliasName)
           .WHERE(po.id() + "=#{" + po.id() + "}");
        return sql.toString();
    }

    /**
     * 根据Id获取po，因为需要po中的tableName，故，传带有Id的po对象。
     * @param po
     * @return
     */
    public String getList(T po) {
        SQL sql = new SQL();
        sql.SELECT(po.table() + tableAliasName);
        sql.WHERE(po.id() + "=#{" + po.id() + "}");
        return sql.toString();
    }

    /**
     * " insert into t_bas_user(name, email, password, createdTime, creatorId, lockVersion, statusId) " +
     " values (#{userName}, #{email}, #{password}, #{createdTime}, 0, #{lockVersion}, 0) ";
     * @param po
     * @return
     */
    public String insert(T po) {
        SQL sql = new SQL();
        sql.INSERT_INTO(po.table())
           .VALUES("name, email, password, createdTime, creatorId, lockVersion, statusId",
                   "#{userName}, #{email}, #{password}, #{createdTime}, 0, #{lockVersion}, 0");

        return sql.toString();
    }

    public String select(T po) {
        String id = po.id();

        SQL sql = new SQL();
        sql.SELECT("o.*");
        sql.FROM(po.table() + tableAliasName);
        sql.WHERE(id + "=#{" + id + "}");
        return sql.toString();
    }

    public String selectList(T po) {
        String id = po.id();

        SQL sql = new SQL();
        sql.SELECT("o.*");
        sql.FROM(po.table() + tableAliasName);
        sql.WHERE(id + "=#{" + id + "}");
        return sql.toString();
    }

    public String update(T po) {
        String id = po.id();

        SQL sql = new SQL();
        sql.UPDATE(po.table());
        sql.SET("lockVersion=1");
        sql.WHERE(id + "=#{" + id + "}");
        return sql.toString();
    }
}