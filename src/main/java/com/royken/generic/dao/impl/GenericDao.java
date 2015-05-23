package com.royken.generic.dao.impl;

import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author KENFACK Valmy-Roi <roykenvalmy@gmail.com>
 * @param <T> 
 * @param <ID>
 */
public class GenericDao<T, ID extends Serializable> implements IGenericDao<T, ID> {
    private Class<T> entityClass;
    @PersistenceContext
    private EntityManager manager;

    public GenericDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getEntityClass() {
        return this.entityClass;
    }

    public EntityManager getManager() throws DataAccessException {
        if (this.manager == null) {
            throw new DataAccessException("Le gestionnaire des entit\u00e9s n'est pas encore d\u00e9fini");
        }
        return this.manager;
    }

    public void setManager(EntityManager manager) throws DataAccessException {
        this.manager = manager;
    }

    public T create(T newInstance) throws DataAccessException{
        this.getManager().persist(newInstance);
        return newInstance;
    }

    public T findById(ID id) throws DataAccessException{
        return (T)this.getManager().find(this.entityClass, id);
    }

    public T update(T transientObject) throws DataAccessException{
         return (T)this.getManager().merge(transientObject);
    }

    public void delete(T persistentObject) throws DataAccessException{
        this.getManager().remove(persistentObject);
    }

    public List<T> findAll() throws DataAccessException {
        return this.getManager().createQuery(" select u from " + this.entityClass.getName() + " u").getResultList();
    }

}
