package com.fox.model.dao.implementation;

import com.fox.HibernateUtil;
import com.fox.model.dao.AbstractDAO;

import com.fox.model.entity.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class RegionDAO implements AbstractDAO<Region> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Region> findAll() throws SQLException {
        List<Region> regions = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            regions = session.createQuery("from Region ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public void create(Region entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity.getName(), entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Region findByName(String name) throws SQLException {
        Region region = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            region = session.get(Region.class, name);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public void update(String name, Region entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Region region = session.get(Region.class, name);
            if (region != null) {
                session.delete(region);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
