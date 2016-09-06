package az.grp.dao;

import az.grp.model.dao.IEntity;

import java.util.List;

/**
 * Created Seymur jr on 10/18/2014.
 */
public interface CacheDAO {

    <T extends IEntity> List<T> load(Class<T> clazz);
}
