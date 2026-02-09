package com.qiuzhitech.mymybatis;

import com.alibaba.fastjson2.JSON;
import com.qiuzhitech.mymybatis.binding.MapperProxyFactory;
import com.qiuzhitech.mymybatis.binding.MapperRegistry;
import com.qiuzhitech.mymybatis.dao.IUserDao;
import com.qiuzhitech.mymybatis.session.SqlSession;
import com.qiuzhitech.mymybatis.session.SqlSessionFactory;
import com.qiuzhitech.mymybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.qiuzhitech.mymybatis.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }


}
