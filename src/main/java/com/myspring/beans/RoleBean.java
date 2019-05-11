package com.myspring.beans;

import com.myspring.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Assylkhan
 * on 11.05.2019
 * @project springFoodOrder
 */
public class RoleBean {

    public static final Long ROLE_ADMIN_ID = 1L;
    public static final Long ROLE_USER_ID = 1L;

    private SessionFactory sessionFactory;

    @Autowired
    public RoleBean(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addRole(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(role);
        transaction.commit();
        session.close();
    }

    public List<Role> getAllRoles() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = criteriaBuilder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        List<Role> allRole = session.createQuery(query).getResultList();
        session.close();
        return allRole;
    }

    public void deleteRole(Long id) {
        Role role = new Role();
        role.setId(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }

    public Role getRole(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = criteriaBuilder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        Role role = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return role;
    }


    public void updateRole(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(role);
        transaction.commit();
        session.close();
    }
}
