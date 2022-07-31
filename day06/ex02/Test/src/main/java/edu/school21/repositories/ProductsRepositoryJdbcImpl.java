package edu.school21.repositories;

import edu.school21.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

    private Connection connection;

    public ProductsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> findAll() {

        PreparedStatement preState;
        ResultSet resultSet = null;
        List<Product> productsList = new ArrayList<Product>();
        try {
            preState = connection.prepareStatement("SELECT * FROM products");
            resultSet = preState.executeQuery();
            while (resultSet.next()) {
                productsList.add(new Product(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getLong("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    @Override
    public Optional<Product> findById(Long id) {

        PreparedStatement preState;
        ResultSet resultSet = null;
        Product product = null;
        try {
            preState = connection.prepareStatement("SELECT * FROM products WHERE id = " + id.toString());
            resultSet = preState.executeQuery();
            if (resultSet.next()) {
                product = new Product(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getLong("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return Optional.ofNullable(product);
    }

    @Override
    public void delete(Long id) {

        PreparedStatement preState;

        try {
            preState = connection.prepareStatement("DELETE FROM products WHERE id = ?");
            preState.setLong(1, id);
            preState.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Product product) {

        PreparedStatement preState;

        try {
            preState = connection.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)");
            preState.setString(1, product.getName());
            preState.setLong(2, product.getPrice());
            preState.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
       PreparedStatement preState;

        try {
            if (findById(product.getId()).isPresent()) {
                preState = connection.prepareStatement("UPDATE products SET "
                        + "name=?, "
                        + "price=? "
                        + "WHERE id=?");
                preState.setString(1, product.getName());
                preState.setLong(2, product.getPrice());
                preState.setLong(3, product.getId());
                preState.execute();
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
