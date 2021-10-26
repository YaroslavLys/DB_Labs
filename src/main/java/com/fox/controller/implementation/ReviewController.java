package com.fox.controller.implementation;

import com.fox.controller.AbstractController;
import com.fox.model.entity.Review;
import com.fox.service.implementation.ReviewService;

import java.sql.SQLException;
import java.util.List;

public class ReviewController implements AbstractController<Review> {

    ReviewService service = new ReviewService();

    @Override
    public List<Review> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Review findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Review entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Review entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
