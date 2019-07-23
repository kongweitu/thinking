package com.boot.thinking.annotion;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from user where user.name=#{name}")
    User queryUserByName(String name);
}
