package com.fox.model.dao.implementation;

import com.fox.HibernateUtil;
import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ReviewDAO implements AbstractDAO<Review> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Review> findAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            reviews = session.createQuery("from Review ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review findById(Integer id) throws SQLException {
        Review review = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            review = session.get(Review.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public void create(Review entity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Review entity) throws SQLException {
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
            Review review = session.get(Review.class, id);
            if (review != null) {
                session.delete(review);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
