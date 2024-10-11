package com.ra.pagination.model.dao.impl;

import com.ra.pagination.model.dao.IProductDao;
import com.ra.pagination.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDaoImpl implements IProductDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll()
    {
        try (Session session = sessionFactory.openSession())
        {
            return session.createQuery("from Product", Product.class).list();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveProduct(Product product)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
            return true;
        }
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }
}
