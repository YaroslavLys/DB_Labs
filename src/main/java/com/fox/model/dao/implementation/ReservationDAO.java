package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Reservation;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO implements AbstractDAO<Reservation> {

    private static final String GET_ALL = "SELECT * FROM lys_db.reservation";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.reservation WHERE id=?";
    private static final String CREATE = "INSERT lys_db.reservation "
            + "(`user_id`, `room_id`, `start_time`, `end_time`, `payment_amount`, `adults`, `kids`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.reservation"
            + " SET user_id=?, room_id=?, start_time=?, end_time=?, payment_amount=?, adults=?, kids=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.reservation WHERE id=?";

    @Override
    public List<Reservation> findAll() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getTimestamp("start_time"),
                        resultSet.getTimestamp("end_time"),
                        resultSet.getInt("payment_amount"),
                        resultSet.getInt("adults"),
                        resultSet.getInt("kids")
                );
                reservations.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public Reservation findById(Integer id) throws SQLException {
        Reservation reservation = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getTimestamp("start_time"),
                        resultSet.getTimestamp("end_time"),
                        resultSet.getInt("payment_amount"),
                        resultSet.getInt("adults"),
                        resultSet.getInt("kids")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void create(Reservation reservation) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(reservation.getUserId()));
            statement.setString(2, String.valueOf(reservation.getRoomId()));
            statement.setString(3, String.valueOf(reservation.getStartTime()));
            statement.setString(4, String.valueOf(reservation.getEndTime()));
            statement.setString(5, String.valueOf(reservation.getPaymentAmount()));
            statement.setString(6, String.valueOf(reservation.getAdults()));
            statement.setString(7, String.valueOf(reservation.getKids()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Reservation reservation) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, reservation.getUserId());
            statement.setInt(2, reservation.getRoomId());
            statement.setTimestamp(3, reservation.getStartTime());
            statement.setTimestamp(4, reservation.getEndTime());
            statement.setInt(5, reservation.getPaymentAmount());
            statement.setInt(6, reservation.getAdults());
            statement.setInt(7, reservation.getKids());
            statement.setInt(8, reservation.getId());
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
