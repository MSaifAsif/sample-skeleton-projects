package com.jpa.dao;

import com.jpa.model.Human;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

/**
 * A DAO implementation for the {@link Human} class
 *
 * @author saifasif
 */
public class HumanDAO extends GenericHibernateDAO<Human, Serializable> {

    //private Criteria criteria = HibernateUtil.getSession().createCriteria(Human.class); 

    public Human getAUserByID(long userID) {
        List<Human> resultList = findByCriteria(Restrictions.eq("id", userID));
        if (!resultList.isEmpty()) {
            return findByCriteria(Restrictions.eq("id", userID)).get(0);
        }
        return null;
    }

    public List<Human> getAllusers() {
        return findAll();
    }

    public List<Human> findByExample(Human exampleInstance) {
        return null;
    }

}