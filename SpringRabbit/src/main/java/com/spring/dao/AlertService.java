package com.spring.dao;

import com.spring.domain.Spittle;

/**
 * Created by Administrator on 2016/11/23.
 */
public interface AlertService {

    void sendSpittleAlert(Spittle spittle);
}
