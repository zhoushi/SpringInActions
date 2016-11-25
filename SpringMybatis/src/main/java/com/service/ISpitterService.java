package com.service;

import com.domain.Spitter;
import com.dao.SpitterMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
@Service(value = "spitterService")

public class ISpitterService{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplates;

    public List<Spitter> findAllSpitters() {
        SpitterMapper spitterMapper = sqlSessionTemplates.getMapper(SpitterMapper.class);
        return spitterMapper.findAllSpitters();
    }
}
