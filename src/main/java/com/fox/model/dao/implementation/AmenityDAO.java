package com.fox.model.dao.implementation;

import com.fox.HibernateUtil;
import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Amenity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class AmenityDAO implements AbstractDAO<Amenity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Amenity> findAll() throws SQLException {
        List<Amenity> amenities = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            amenities = session.createQuery("from Amenity ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Amenity findById(Integer id) throws SQLException {
        Amenity amenity = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            amenity = session.get(Amenity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenity;
    }

    @Override
    public void create(Amenity entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Amenity entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Amenity amenity = session.get(Amenity.class, id);
            if (amenity != null) {
                session.delete(amenity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
