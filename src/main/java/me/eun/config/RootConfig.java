package me.eun.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import me.eun.mapper.BoardMapper;
import me.eun.service.BoardService;
import me.eun.service.BoardServiceImpl;

@Configuration
@MapperScan("me.eun.mapper")

public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost/board_ex07");
		config.setUsername("root");
		config.setPassword("1234");
		return new HikariDataSource(config);
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory () throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean 
		= new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
}