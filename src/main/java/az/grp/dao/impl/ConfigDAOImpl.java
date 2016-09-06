package az.grp.dao.impl;


import az.grp.dao.ConfigDAO;
import az.grp.model.dao.Config;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * Created by jr on 9/5/2014.
 */

@Repository("configDAO")
public class ConfigDAOImpl extends BaseDAOImpl
        implements ConfigDAO {

    private static Logger logger = Logger.getLogger(ConfigDAOImpl.class);

    @Override
    public void load() {

    }

    @Override
    @Transactional
    public Config get(String key) {

        return (Config) sessionFactory.getCurrentSession()
                .createCriteria(Config.class)
                .add(Restrictions.eq("name", key))
                .uniqueResult();
    }
}
