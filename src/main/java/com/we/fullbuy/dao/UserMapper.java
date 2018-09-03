package com.we.fullbuy.dao;

import com.we.fullbuy.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*new*/
    User selectByLoginName(@Param("loginName") String loginName);

    int updateUserState(@Param("userId") Integer userId, @Param("userState") int userState);
}