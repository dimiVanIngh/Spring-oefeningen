package be.vdab.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class CreateTestDataSourceBean {
	@Bean
	DataSource dataSource() {
		//  ; echte db
		//return new DriverManagerDataSource("jdbc:mysql://localhost/groenetenen?useSSL=false", "cursist", "cursist");
		// in memory db
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	}
}
