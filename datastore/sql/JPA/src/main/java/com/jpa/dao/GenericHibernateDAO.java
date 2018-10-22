package com.jpa.dao;

import com.jpa.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Default implementation. All hail !
 *
 * @param <T>
 * @param <ID>
 * @author msaif
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable>
        implements GenericDAO<T, ID> {

    private static final Logger log = Logger.getLogger(GenericHibernateDAO.class);
    private Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        try {
            if (session == null) {
                log.info("getting current session [getCurrentSession()]");
                session = HibernateUtil.getSessionFactory().getCurrentSession();
            }
        } catch (HibernateException e) {
            log.error("No Session is associated with current Thread. " +
                    "Make sure that you are initiating DAO instances in the TransactionScope.", e);
        }
        return session;
    }

    public void setSession(Session s) {
        this.session = s;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    public T findById(ID id, boolean lock) {
        T entity;
        if (lock)
            entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
        else
            entity = (T) getSession().load(getPersistentClass(), id);

        return entity;
    }

    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    public T makePersistent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void makeTransient(T entity) {
        getSession().delete(entity);
    }

    public void flush() {
        getSession().flush();
    }

    public T save(T entity) {
        getSession().save(entity);
        return entity;
    }

    public void clear() {
        getSession().clear();
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    /**
     * Get only the first object that matches the criterea
     *
     * @param criterion
     * @return
     */
    protected T getFirstObjectByCriteria(Criterion... criterion) {
        return findByCriteria(criterion).get(0);
    }

    /**
     * Criteria method for pagination purpose
     *
     * @param lowerBound
     * @param upperBound
     * @param criterion
     * @return A list of the result within the bounds defined
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteriaPaginated(int lowerBound, int upperBound, Criterion... criterion) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.setFirstResult(lowerBound);
        criteria.setMaxResults(upperBound);
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        return criteria.list();
    }

}  
