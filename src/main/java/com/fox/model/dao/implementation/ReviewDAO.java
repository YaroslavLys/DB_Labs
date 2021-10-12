package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Review;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements AbstractDAO<Review> {
    private static final String GET_ALL = "SELECT * FROM lys_db.review";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.review WHERE id=?";
    private static final String CREATE = "INSERT lys_db.review "
            + "(`text`, `rate`, `hotel_id`, `user_id`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.review"
            + " SET text=?, rate=?, hotel_id=?, user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.review WHERE id=?";

    @Override
    public List<Review> findAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("text"),
                        resultSet.getInt("rate"),
                        resultSet.getInt("hotel_id"),
                        resultSet.getInt("user_id")
                );
                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review findById(Integer id) throws SQLException {
        Review review = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("text"),
                        resultSet.getInt("rate"),
                        resultSet.getInt("hotel_id"),
                        resultSet.getInt("user_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public void create(Review review) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(review.getText()));
            statement.setString(2, String.valueOf(review.getRate()));
            statement.setString(3, String.valueOf(review.getHotelId()));
            statement.setString(4, String.valueOf(review.getUserId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Review review) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, review.getText());
            statement.setInt(2, review.getRate());
            statement.setInt(3, review.getHotelId());
            statement.setInt(4, review.getUserId());
            statement.setInt(5, review.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
