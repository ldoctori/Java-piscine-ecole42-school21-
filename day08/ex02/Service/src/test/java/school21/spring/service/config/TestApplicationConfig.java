package school21.spring.service.config;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

public class TestApplicationConfig {

    DataSource dataSource;
    public void resetDb() throws SQLException {
        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
        this.dataSource = dbBuilder.setName("Database for test")
                .setType(HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

}
