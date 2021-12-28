package com.example.powermanager.dao;

import com.example.powermanager.model.SysUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);
}
