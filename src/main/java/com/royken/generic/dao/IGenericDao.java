package com.royken.generic.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author KENFACK Valmy-Roi <roykenvalmy@gmail.com>
 * @param <T> The entity class
 * @param <ID>  The id
 */
public interface IGenericDao<T, ID extends Serializable> {
    /**
     * Insert the object in the database
     * @param newInstance the object to be inserted 
     * @return the same object
     * @throws com.royken.generic.dao.DataAccessException
     */
    T create(T newInstance) throws DataAccessException;

    
    /**
     * Find in the database the object which id is the parameter
     * @param id the id of the object we are searching for
     * @return the object with the given id
     * @throws com.royken.generic.dao.DataAccessException
     */
     T findById(ID id) throws DataAccessException;
    /**
     * Finds all the occurences of the entity in the database
     * @return a list of the given entity
     * @throws com.royken.generic.dao.DataAccessException
     */    
    public List<T> findAll() throws DataAccessException;

    
    /**
     * Modify an object in the database
     * @param transientObject the object with new new attributes
     * @return 
     * @throws com.royken.generic.dao.DataAccessException
     */
    T update(T transientObject) throws DataAccessException;

    /**
     * Delete the given object in the database
     * @param persistentObject
     * @throws com.royken.generic.dao.DataAccessException
     */
    void delete(T persistentObject) throws DataAccessException;
}
