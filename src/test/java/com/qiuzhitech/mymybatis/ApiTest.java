package com.qiuzhitech.mymybatis;

import com.qiuzhitech.mymybatis.binding.MapperProxyFactory;
import com.qiuzhitech.mymybatis.binding.MapperRegistry;
import com.qiuzhitech.mymybatis.dao.IUserDao;
import com.qiuzhitech.mymybatis.io.Resources;
import com.qiuzhitech.mymybatis.session.SqlSession;
import com.qiuzhitech.mymybatis.session.SqlSessionFactory;
import com.qiuzhitech.mymybatis.session.SqlSessionFactoryBuilder;
import com.qiuzhitech.mymybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }

}
