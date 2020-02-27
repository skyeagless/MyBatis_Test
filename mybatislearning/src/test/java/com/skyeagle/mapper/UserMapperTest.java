package com.skyeagle.mapper;

import com.mybatis.mapper.UserMapper;
import com.skyeagle.mybatisTest.model.SysRole;
import com.skyeagle.mybatisTest.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest{
    SqlSession sqlSession = getSqlSession();
    @Test
    public void testSelectById(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("admin",user.getUserName());
        }finally{
            sqlSession.close();
        }
    }
    @Test
    public void testSelectAll(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            Assert.assertTrue(userList.size()>0);
        }finally{
            sqlSession.close();
        }
    }
    @Test
    public void testSelectRolesByUserId(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            Assert.assertTrue(roleList.size()>0);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testInsert(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybtais.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //执行的SQL影响的行数
            int result = userMapper.insert(user);
            Assert.assertEquals(1,result);
            //但这种方法没有写入主键值
        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory,openSession()并不自动提交
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testInsert2(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybtais.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //执行的SQL影响的行数
            int result = userMapper.insert2(user);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(user.getId());
        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory,openSession()并不自动提交
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testInsert3(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybtais.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreateTime(new Date());
            //执行的SQL影响的行数
            int result = userMapper.insert3(user);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(user.getId());
        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory,openSession()并不自动提交
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testUpdateById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //先查出一个user对象
            SysUser user = userMapper.selectById(1L);
            user.setUserName("admin_test");
            user.setUserEmail("test#dasfsaf.kk");
            int result = userMapper.updateById(user);
            Assert.assertEquals(1, result);
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);
            int result = userMapper.deleteById(user);
            Assert.assertEquals(1, result);
            Assert.assertNull(userMapper.selectById(1L));
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testselectRolesByUserIdAndRoleEnabled(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled(1L,1);
            Assert.assertTrue(userList.size()>0);

        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory,openSession()并不自动提交
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    @Test
    public void testselectRolesByUserIdAndRoleEnabled2(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //先查出一个user对象
            SysUser user = userMapper.selectById(1L);
            //再查出一个role对象
            SysRole role = userMapper.selectByRoleId(1L);
            List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled2(user,role);
            Assert.assertTrue(userList.size()>0);

        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory,openSession()并不自动提交
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}



