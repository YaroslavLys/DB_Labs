package com.fox.model.dao.implementation;

import com.fox.HibernateUtil;
import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.HotelChain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class HotelChainDAO implements AbstractDAO<HotelChain> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<HotelChain> findAll() throws SQLException {
        List<HotelChain> hotelChains = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            hotelChains = session.createQuery("from HotelChain ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelChains;
    }

    @Override
    public HotelChain findById(Integer id) throws SQLException {
        HotelChain hotelChain = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            hotelChain = session.get(HotelChain.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelChain;
    }

    @Override
    public void create(HotelChain entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, HotelChain entity) throws SQLException {
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
            HotelChain hotelChain = session.get(HotelChain.class, id);
            if (hotelChain != null) {
                session.delete(hotelChain);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
