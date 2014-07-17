/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.hsian.xms.repositories.mapper;

import org.apache.ibatis.annotations.*;
import org.hsian.xms.model.common.AbstractPo;
import org.hsian.xms.repositories.sql.SQLTemplate;

import java.util.List;

/**
 * MyBatis CRUD基接口 
 * @author HSIAN.LU
 * 
 * @param <T> 处理的POJO对象 
 */  
public interface BaseMapper<T extends AbstractPo> {

    /**
     * 标准删除 根据po中的Id删除po。
     * @param po
     */
    @DeleteProvider(type = SQLTemplate.class, method = "delete")
    void delete(T po);

    /**
     * 标准创建
     * @param po
     * @return
     */
    @InsertProvider(type = SQLTemplate.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(T po);

    /**
     *
     * @param po
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "select")
    T select(T po);

    /**
     *
     * @param po
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectList")
    List<T> selectList(T po);

    /**
     *
     * @param po
     * @return
     */
    @UpdateProvider(type = SQLTemplate.class, method = "update")
    int update(T po);

}