package com.qiuzhitech.mymybatis.builder;

import com.qiuzhitech.mymybatis.session.Configuration;

public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}