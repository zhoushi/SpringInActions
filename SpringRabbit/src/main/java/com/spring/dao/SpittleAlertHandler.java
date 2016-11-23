package com.spring.dao;

import com.spring.domain.Spittle;

/**
 * Created by Administrator on 2016/11/23.
 */
public class SpittleAlertHandler {

    public void handleSpittleAlert(Spittle spittle){
        System.out.println(spittle.getMessage());
    }
}
