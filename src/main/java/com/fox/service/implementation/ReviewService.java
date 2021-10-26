package com.fox.service.implementation;

import com.fox.model.dao.implementation.ReviewDAO;
import com.fox.model.entity.Review;
import com.fox.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class ReviewService implements AbstractService<Review> {

    private final ReviewDAO dao = new ReviewDAO();

    @Override
    public List<Review> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Review findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Review entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Review entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
