package com.mybatis.mapper;

import com.skyeagle.mybatisTest.model.SysRole;
import com.skyeagle.mybatisTest.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper{
    SysUser selectById(Long id);
    SysRole selectByRoleId(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRolesByUserId(Long userID);
    Integer insert(SysUser user);
    Integer insert2(SysUser user);
    Integer insert3(SysUser user);
    Integer updateById(SysUser user);
    Integer deleteById(SysUser user);
    //多接口参数要使用param注解
    List<SysRole> selectRolesByUserIdAndRoleEnabled(
            @Param("userId") Long userId,
            @Param("enabled") Integer enabled);
    //多接口JavaBean类型参数
    List<SysRole> selectRolesByUserIdAndRoleEnabled2(
            @Param("user") SysUser user,
            @Param("role") SysRole role);

}