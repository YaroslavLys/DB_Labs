package com.fox.model.dao.implementation;

import com.fox.HibernateUtil;
import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ReservationDAO implements AbstractDAO<Reservation> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Reservation> findAll() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reservations = session.createQuery("from Reservation ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public Reservation findById(Integer id) throws SQLException {
        Reservation reservation = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reservation = session.get(Reservation.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void create(Reservation entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Reservation entity) throws SQLException {
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
            Reservation reservation = session.get(Reservation.class, id);
            if (reservation != null) {
                session.delete(reservation);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
