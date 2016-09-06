package az.grp.dao.impl;


import az.grp.dao.CacheDAO;
import az.grp.model.dao.IEntity;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jr on 10/18/2014.
 */

@Repository("cacheDAO")
@Transactional
public class CacheDAOImpl extends BaseDAOImpl implements CacheDAO {


    public CacheDAOImpl() {
    }

    @Override
    public <T extends IEntity> List<T> load(Class<T> clazz) {

        return sessionFactory.getCurrentSession().createCriteria(clazz)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .addOrder(org.hibernate.criterion.Order.asc("id"))
                .list();
    }
}
