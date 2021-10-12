package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Country;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements AbstractDAO<Country> {

    private static final String GET_ALL = "SELECT * FROM lys_db.country";
    private static final String GET_BY_NAME = "SELECT * FROM lys_db.country WHERE name=?";
    private static final String CREATE = "INSERT lys_db.country "
            + "(`name`, `population`, `area`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.country"
            + " SET population=?, area=? WHERE name=?";
    private static final String DELETE = "DELETE FROM lys_db.country WHERE name=?";

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(
                        resultSet.getString("name"),
                        resultSet.getInt("population"),
                        resultSet.getInt("area")
                );
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country findByName(String name) throws SQLException {
        Country country = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                country = new Country(
                        resultSet.getString("name"),
                        resultSet.getInt("population"),
                        resultSet.getInt("area")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void create(Country country) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(country.getName()));
            statement.setString(2, String.valueOf(country.getPopulation()));
            statement.setString(3, String.valueOf(country.getArea()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String name, Country country) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, country.getPopulation());
            statement.setInt(2, country.getArea());
            statement.setString(3, country.getName());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, name);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
