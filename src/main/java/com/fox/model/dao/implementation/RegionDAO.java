package com.fox.model.dao.implementation;

import com.fox.model.dao.AbstractDAO;
import com.fox.model.entity.Region;
import com.fox.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO implements AbstractDAO<Region> {
    private static final String GET_ALL = "SELECT * FROM lys_db.region";
    private static final String GET_BY_NAME = "SELECT * FROM lys_db.region WHERE name=?";
    private static final String CREATE = "INSERT lys_db.region "
            + "(`name`, `country_name`, `climate`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE lys_db.region"
            + " SET climate=? WHERE name=? AND country_name=?";
    private static final String DELETE = "DELETE FROM lys_db.region WHERE name=?";


    @Override
    public List<Region> findAll() throws SQLException {
        List<Region> regions = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(
                        resultSet.getString("name"),
                        resultSet.getString("country_name"),
                        resultSet.getString("climate")
                );
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public void create(Region region) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(region.getName()));
            statement.setString(2, String.valueOf(region.getCountryName()));
            statement.setString(3, String.valueOf(region.getClimate()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Region findByName(String name) throws SQLException {
        Region region = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                region = new Region(
                        resultSet.getString("name"),
                        resultSet.getString("country_name"),
                        resultSet.getString("climate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public void update(String name, Region region) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, region.getClimate());
            statement.setString(2, region.getName());
            statement.setString(3, region.getCountryName());
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
