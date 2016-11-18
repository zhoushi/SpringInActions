package com.spring.dao;

import com.spring.domain.Spitter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */

public interface SpitterMapper {

    List<Spitter> findAllSpitters();
}
