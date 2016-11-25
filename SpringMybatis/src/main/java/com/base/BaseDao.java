package com.base;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.PersistenceExceptionTranslator;

/**
 * Created by Administrator on 2016/11/18.
 */
public class BaseDao extends SqlSessionTemplate {
    public BaseDao(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    public BaseDao(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
        super(sqlSessionFactory, executorType);
    }

    public BaseDao(SqlSessionFactory sqlSessionFactory, ExecutorType executorType, PersistenceExceptionTranslator exceptionTranslator) {
        super(sqlSessionFactory, executorType, exceptionTranslator);
    }
}
