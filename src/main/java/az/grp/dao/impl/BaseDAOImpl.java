package az.grp.dao.impl;

import az.grp.dao.BaseDAO;
import az.grp.model.dao.Groups;
import az.grp.model.dao.IEntity;
import az.grp.model.dao.Lesson;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Seymur on 12/11/2015.
 */
@Transactional
@Repository("baseDAO")
public class BaseDAOImpl implements BaseDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Object obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    @Override
    public void update(Object obj) {
        sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public void delete(Object obj) {
        sessionFactory.getCurrentSession().delete(obj);
    }

    @Override
    public <T extends IEntity> List<T> find(Class<T> clazz, String field, Object value) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);

        if (field != null && !field.isEmpty())
            criteria.add(Restrictions.eq(field, value));

        List<T> entities = criteria.list();

        if (entities == null) entities = new ArrayList<T>();

        return entities;
    }

    @Override
    public <T extends IEntity> List<T> find(Class<T> clazz, Map<String, Object> params) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
        criteria.add(Restrictions.allEq(params));
        criteria.addOrder(Order.asc("id"));
        List<T> entities = criteria.list();

        return entities;
    }


    @Override
    public <T extends IEntity> List<T> find_OrderDesc(Class<T> clazz, Map<String, Object> params) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);

        criteria.add(Restrictions.allEq(params));
        criteria.addOrder(Order.desc("id"));
        List<T> entities = criteria.list();

        return entities;

    }


    @Override
    public <T extends IEntity> T findWithParams(Class<T> clazz, Map<String, Object> params) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
        for (String key : params.keySet())
            criteria.add(Restrictions.eq(key, params.get(key)));

        List<T> list = (List<T>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public <T extends IEntity> T findWithParams(Class<T> clazz, String field, Object value) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);

        criteria.add(Restrictions.eq(field, value));

        List<T> list = (List<T>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public <T extends IEntity> List<T> like(Class<T> clazz, Map<String, Object> params) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);

        for (String key : params.keySet())
            criteria.add(Restrictions.like(key, params.get(key)));

        List<T> list = criteria.list();

        return list;
    }

    @Override
    public <T extends IEntity> List<T> between(Class<T> clazz, String eqField1, Object eqValue1, String eqField2, Object eqValue2, String betweenColumn, Object firstDate, Object secondDate) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);

        criteria.add(Restrictions.eq(eqField1, eqValue1));
        criteria.add(Restrictions.eq(eqField2, eqValue2));
        criteria.add(Restrictions.between(betweenColumn, firstDate, secondDate));

        List<T> list = criteria.list();


        return list;
    }

    @Override
    public <T extends IEntity> int countCoulm(Class<T> clazz, String countField, String eqField, Object eqObj) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);


        criteria.add(Restrictions.eq(eqField, eqObj));
        criteria.setProjection(Projections.count(countField));


        return Integer.parseInt(criteria.uniqueResult().toString());
    }

    @Override
    public <T extends IEntity> Lesson nowLessonEq(Class<T> clazz, Groups groups, int day, int minute, int weekType) {

        String sql = "Select * " +
                "from lesson\n" +
                "where start_time <= :time and \n" +
                ":time  < end_time \n" +
                "and group_id = :group_id and day = :day \n" +
                "and week_type = :week_type";

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(clazz);
        //noinspection JpaQueryApiInspection
        query.setParameter("group_id", groups.getId());
        //noinspection JpaQueryApiInspection
        query.setParameter("day", day);
        //noinspection JpaQueryApiInspection
        query.setParameter("time", minute);
        //noinspection JpaQueryApiInspection
        query.setParameter("week_type", weekType);

        List list = query.list();
        Lesson lesson = list.isEmpty() ? null : (Lesson) list.get(0);

        return lesson;
    }

    @Override
    public Lesson secondLessonEq(Groups groups, int day, int minute) {

        String sql = "Select * from lesson \n" +
                "where start_time < :time + 20 and " +
                ":time + 20 < end_time " +
                "and group_id = :group_id and day = :day";

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Lesson.class);
        //noinspection JpaQueryApiInspection
        query.setParameter("group_id", groups.getId());
        //noinspection JpaQueryApiInspection
        query.setParameter("day", day);
        //noinspection JpaQueryApiInspection
        query.setParameter("time", minute);

        List list = query.list();
        Lesson lesson = list.isEmpty() ? null : (Lesson) list.get(0);

        return lesson;
    }
}
