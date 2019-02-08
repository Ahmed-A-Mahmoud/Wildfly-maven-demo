package com.sample.ejb;

import com.sample.model.Property;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless

public class PropertyManager {

    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;

    /*
     public void delete(){
     Query query = em.createQuery("DELETE FROM Property p");
                
     query.executeUpdate();
     em.flush();
     }
     */

    public void save(Property p) {
        em.persist(p);

    }

    public List<Property> getProperty() {
        Query query = em.createQuery("FROM Property p");

        List<Property> list = query.getResultList();
        return list;
    }

    public boolean addProperty(Property property){
        em.persist(property);
        return true;
    }

}
