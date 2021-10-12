package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.HotelChain;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelChainDAO implements AbstractDAO<HotelChain> {

    private static final String GET_ALL = "SELECT * FROM lys_db.hotel_chain";
    private static final String GET_BY_ID = "SELECT * FROM lys_db.hotel_chain WHERE id=?";
    private static final String CREATE = "INSERT lys_db.hotel_chain "
            + "(`name`, `type`, `parent_company`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.hotel_chain"
            + " SET name=?, type=?, parent_company=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lys_db.hotel_chain WHERE id=?";

    @Override
    public List<HotelChain> findAll() throws SQLException {
        List<HotelChain> hotelChains = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HotelChain hotelChain = new HotelChain(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("parent_company")
                );
                hotelChains.add(hotelChain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelChains;
    }

    @Override
    public HotelChain findById(Integer id) throws SQLException {
        HotelChain hotelChain = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hotelChain = new HotelChain(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("parent_company")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelChain;
    }

    @Override
    public void create(HotelChain hotelChain) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(hotelChain.getName()));
            statement.setString(2, String.valueOf(hotelChain.getType()));
            statement.setString(3, String.valueOf(hotelChain.getParentCompany()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, HotelChain hotelChain) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, hotelChain.getName());
            statement.setString(2, hotelChain.getType());
            statement.setString(3, hotelChain.getParentCompany());
            statement.setInt(4, hotelChain.getId());
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
