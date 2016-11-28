package com.spring.service;

import com.spring.domain.Spitter;
import com.spring.domain.Spittle;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    void saveSpittle(Spittle spittle);

    void saveSpitter(Spitter spitter);
    Spitter getSpitter(long id);
    void startFollowing(Spitter follower, Spitter followee);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);
    List<Spittle> getSpittlesForSpitter(String username);
    Spitter getSpitter(String username);

    Spittle getSpittleById(long id);
    void deleteSpittle(long id);

    List<Spitter> getAllSpitters();
}
