package com.qiuzhitech.mymybatis.session.defaults;

import com.qiuzhitech.mymybatis.binding.MapperRegistry;
import com.qiuzhitech.mymybatis.session.Configuration;
import com.qiuzhitech.mymybatis.session.SqlSession;
import com.qiuzhitech.mymybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}