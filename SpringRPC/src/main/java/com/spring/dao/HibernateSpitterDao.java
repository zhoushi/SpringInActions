package com.spring.dao;

import com.spring.domain.Spitter;
import com.spring.domain.Spittle;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
@Repository
@Transactional//事务添加
public class HibernateSpitterDao implements SpitterDao {

    @Autowired
    private SessionFactory sessionFactory;

//    //依赖注入
//    @Autowired
//    public HibernateSpitterDao(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }
    //
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);//<co id="co_useSession"/>
    }

    @Override
    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    /**
     * createCriteria是如何执行的？
     * @return
     */
    @Override
    public List<Spittle> getRecentSpittle() {
        List<Spittle> list = currentSession().createCriteria(Spittle.class).list();
        return list;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        currentSession().save(spittle);
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        Query query = currentSession().createQuery("from Spittle where spitter_id=:id");
        query.setParameter("id", spitter.getId());
        List<Spittle> list = query.list();
        return list;
    }

    /**
     * 使用Hibernate Query
     * @param username
     * @return
     */
    @Override
    public Spitter getSpitterByUsername(String username) {
        Query query = currentSession().createQuery("from Spitter where username=:name");
        query.setParameter("name",username);

        List<Spitter> list = query.list();
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public void deleteSpittle(long id) {
        currentSession().delete(getSpittleById(id));

    }

    @Override
    public Spittle getSpittleById(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return null;
    }
}
