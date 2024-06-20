package tech.csm.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hc = new HikariConfig();
		hc.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hc.setJdbcUrl("jdbc:mysql://localhost:3306/batch_technology");
		hc.setUsername("root");
		hc.setPassword("root");
		hc.setMaximumPoolSize(10);
		hc.setMinimumIdle(10);
		return new HikariDataSource(hc);	
	}

}
