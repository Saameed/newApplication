package az.grp.dao;


import az.grp.model.dao.Config;

/**
 * Created by Seymur on 9/5/2014.
 */

public interface ConfigDAO extends BaseDAO {

    void load();
    Config get(String key);
}
