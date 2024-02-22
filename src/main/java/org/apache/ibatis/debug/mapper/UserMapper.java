package org.apache.ibatis.debug.mapper;

import org.apache.ibatis.debug.entity.User;

import java.util.List;

/**
 * @author : zhanghua
 * @date : 2023/1/29
 */
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);


}
