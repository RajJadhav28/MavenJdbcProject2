package in.quastech.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {
	
	@Bean
	DriverManagerDataSource mydatasource()
	{
	DriverManagerDataSource datasource=new DriverManagerDataSource();
	 datasource.setDriverClassName("com.mysql.jdbc.Driver");
	 datasource.setUrl("jdbc:mysql://localhost:3306/basicdb2");
	 datasource.setUsername("root");
	 datasource.setPassword("admin369");
	 return datasource;
	}
	@Bean
	JdbcTemplate myjdbctemplate() {
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(mydatasource());
		return jdbctemplate;
		
	}

}
