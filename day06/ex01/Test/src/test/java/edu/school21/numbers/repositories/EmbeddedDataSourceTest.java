
package edu.school21.numbers.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class EmbeddedDataSourceTest {

    @Test
    @BeforeEach
    public void init() throws Exception {
        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
        DataSource dataSource = dbBuilder.setName("Database for test")
                                            .setType(HSQL)
                                            .addScript("schema.sql")
                                            .addScript("data.sql")
                                            .build();
        Assertions.assertNotNull(dataSource.getConnection());

    }
}