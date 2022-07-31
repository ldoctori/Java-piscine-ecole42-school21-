package edu.school21.numbers.repositories;

import edu.school21.models.Product;
import edu.school21.repositories.ProductsRepository;
import edu.school21.repositories.ProductsRepositoryJdbcImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class ProductsRepositoryJdbcImplTest {

    Connection connection;

    @Test
    @BeforeEach
    public void resetDb() throws SQLException {
        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
        DataSource dataSource = dbBuilder.setName("Database for test")
                .setType(HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        this.connection = dataSource.getConnection();
    }


    @Test
    public void findAllTest() {

        final List<Product> EXPECTED_FIND_ALL_PRODUCTS = new ProductsRepositoryJdbcImpl(connection).findAll();
        final int SIZE = 8;

        Assertions.assertEquals(SIZE, EXPECTED_FIND_ALL_PRODUCTS.size());
    }

    @Test
    public void findByIdTestEqual() {
        Long id = Long.valueOf(0);
        final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(id,
                                                            "something1",
                                                            Long.valueOf(546466));
        Product findProduct = new ProductsRepositoryJdbcImpl(connection).findById(id).orElse(null);
        Assertions.assertNotNull(findProduct);
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT.getId(), findProduct.getId());
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT.getName(), findProduct.getName());
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT.getPrice(), findProduct.getPrice());
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 2, 3, 4, 5, 6, 7})
    public void findByIdTestTrue(Long id) {
        Assertions.assertTrue(new ProductsRepositoryJdbcImpl(connection).findById(id).isPresent());
    }

    @ParameterizedTest
    @ValueSource(longs = {8, 9, 10, 11, 12, 13, 14})
    public void findByIdTestFalse(Long id) {
        Assertions.assertFalse(new ProductsRepositoryJdbcImpl(connection).findById(id).isPresent());
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 2, 3, 4, 5, 6, 7})
    public void deleteTest(Long id) {
        ProductsRepositoryJdbcImpl product = new ProductsRepositoryJdbcImpl(connection);
        product.delete(id);
        findByIdTestFalse(id);
    }

    @Test
    public void saveTest() {
        ProductsRepositoryJdbcImpl products = new ProductsRepositoryJdbcImpl(connection);
        Long newId = Long.valueOf(8);
        final Product EXPECTED_PRODUCT = new Product(newId, "somehing new", Long.valueOf(12848));
        products.save(EXPECTED_PRODUCT);
        findByIdTestTrue(newId);
    }

    @Test
    public void updateTestFalse() {
        Long newId = Long.valueOf(8);
        final Product EXPECTED_UPDATED_PRODUCT = new Product(newId, "somehing new", Long.valueOf(12848));
        ProductsRepositoryJdbcImpl products = new ProductsRepositoryJdbcImpl(connection);
        products.update(EXPECTED_UPDATED_PRODUCT);
        Product findProduct = new ProductsRepositoryJdbcImpl(connection).findById(newId).orElse(null);
        Assertions.assertNull(findProduct);
    }


    @Test
    public void updateTestTrue() {
        Long newId = Long.valueOf(0);
        final Product EXPECTED_UPDATED_PRODUCT = new Product(newId, "somehing new", Long.valueOf(12848));
        ProductsRepositoryJdbcImpl products = new ProductsRepositoryJdbcImpl(connection);
        products.update(EXPECTED_UPDATED_PRODUCT);
        Product findProduct = new ProductsRepositoryJdbcImpl(connection).findById(newId).orElse(null);
        Assertions.assertNotNull(findProduct);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT.getId(), findProduct.getId());
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT.getName(), findProduct.getName());
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT.getPrice(), findProduct.getPrice());
    }
}