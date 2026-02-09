package com.qiuzhitech.mymybatis.session.defaults;

import com.qiuzhitech.mymybatis.binding.MapperRegistry;
import com.qiuzhitech.mymybatis.session.SqlSession;
import com.qiuzhitech.mymybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}