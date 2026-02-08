package com.qiuzhitech.mymybatis;

import com.alibaba.fastjson2.JSON;
import com.qiuzhitech.mymybatis.binding.MapperProxyFactory;
import com.qiuzhitech.mymybatis.dao.IUserDao;
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
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.qiuzhitech.mymybatis.dao.IUserDao.queryUserName", "SQL for query userName");

        IUserDao userDao = factory.newInstance(sqlSession);
        String result = userDao.queryUserName("1");
        logger.info("test result: {}", JSON.toJSONString(result));

    }

    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                ((proxy, method, args) -> "This is proxy")
        );
        String result = userDao.queryUserName("1");
        logger.info("Test result: {}", result);
    }


}
