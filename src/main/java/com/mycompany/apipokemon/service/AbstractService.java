/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apipokemon.service;

import com.mycompany.apipokemon.utils.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author igor_
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractService<T extends Model<ID>, ID extends Serializable> implements Serializable {

    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    public AbstractService() {
        Class<?> clazz = getClass();
        do {
            if (clazz.getSuperclass().equals(AbstractService.class)) {
                break;
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        this.type = (Class<T>) ((ParameterizedType) clazz
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(Long id) {
        return this.entityManager.find(type, id);
    }

    public List<T> findAll() {
        return createSession().createCriteria(type).list();
    }

    @Transactional
    public void remove(T object) {
        this.entityManager.remove(this.entityManager.getReference(this.type, object.getId()));
    }

    @Transactional
    public void create(T object) {
        this.entityManager.persist(object);
    }

    @Transactional
    public void update(T object) {
        this.entityManager.merge(object);
    }

    @Transactional
    public void save(T object) {
        if (object.getId() == null) {
            this.entityManager.persist(object);
        } else {
            this.entityManager.merge(object);
        }
    }

    protected Session createSession() {
        return (Session) this.entityManager.getDelegate();
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected Criteria getCriteria() {
        return createSession().createCriteria(type);
    }
}