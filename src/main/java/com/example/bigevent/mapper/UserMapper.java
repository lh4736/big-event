package com.example.bigevent.mapper;

import com.example.bigevent.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author lh
 * @Date 2024/3/11 22:37
 */
@Mapper
public interface UserMapper {
    @Select("Select * from user where username = #{username}")
    User findByUserName(String username);

    @Insert("insert into user(username,password,create_time,update_time)"+
    " values(#{username},#{password},now(),now())")
    void add(@Param(("username")) String username,@Param(("password")) String password);
}
