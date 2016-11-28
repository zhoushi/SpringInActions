package com.spring.dao;

/**
 * Created by Administrator on 2016/11/28.
 */

import com.spring.domain.Spitter;
import com.spring.domain.Spittle;

import java.util.List;

/**
 * dao接口
 */
public interface SpitterDao {
    //添加
    void addSpitter(Spitter spitter);

    //保存
    void saveSpitter(Spitter spitter);

    //通过id得到spitter
    Spitter getSpitterById(long id);

    //spittle 列表
    List<Spittle> getRecentSpittle();

    //
    void saveSpittle(Spittle spittle);

    //通过spitter得到spittle
    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    //通过username得到spitter
    Spitter getSpitterByUsername(String username);

    //删除
    void deleteSpittle(long id);

    //得到
    Spittle getSpittleById(long id);

    List<Spitter> findAllSpitters();
}
