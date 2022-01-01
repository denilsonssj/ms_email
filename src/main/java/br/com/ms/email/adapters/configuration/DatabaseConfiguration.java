package br.com.ms.email.adapters.configuration;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Value("${database.config.url}")
    private String url;

    @Value("${database.config.username}")
    private String username;

    @Value("${database.config.password}")
    private String password;

    @Value("${database.config.driver-classname}")
    private String driverClassname;

    @Bean
    public DataSource dataSource() {
        HikariConfig databaseConfig = new HikariConfig();
        databaseConfig.setJdbcUrl(this.url);
        databaseConfig.setUsername(this.username);
        databaseConfig.setPassword(this.password);
        databaseConfig.setDriverClassName(this.driverClassname);
        return new HikariDataSource(databaseConfig);
    }

}
