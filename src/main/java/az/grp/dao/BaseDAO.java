package az.grp.dao;

import az.grp.model.dao.Groups;
import az.grp.model.dao.IEntity;
import az.grp.model.dao.Lesson;
import az.grp.model.dao.Summary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Seymur on 12/10/2015.
 */
public interface BaseDAO {


    void save(Object obj);

    void update(Object obj);

    void delete(Object obj);

    <T extends IEntity> List<T> find(Class<T> clazz, String field, Object value);

    <T extends IEntity> List<T> find(Class<T> clazz, Map<String, Object> params);

    <T extends IEntity> List<T> find_OrderDesc(Class<T> clazz, Map<String, Object> params);

    <T extends IEntity> T findWithParams(Class<T> clazz, Map<String, Object> params);

    <T extends IEntity> T findWithParams(Class<T> clazz, String field, Object value);

    <T extends IEntity> List<T> like(Class<T> clazz, Map<String, Object> params);

    <T extends IEntity> List<T> between(Class<T> clazz, String eqField1, Object eqValue1, String eqField2, Object eqValue2, String betweenColumn, Object firstDate, Object secondDate);

    <T extends IEntity> int countCoulm(Class<T> clazz, String countField, String eqField, Object eqObj);

    <T extends IEntity> Lesson nowLessonEq(Class<T> clazz, Groups groups, int day, int minute, int weekType);

    Lesson secondLessonEq(Groups groups, int i, int minute);
}
