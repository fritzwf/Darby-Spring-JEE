package com.feuersoft.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@PropertySource("classpath:persistence-mysql.properties")
@ComponentScan(basePackages="com.feuersoft.springsecurity.demo")
public class DemoAppConfig {

  // set up variable to hold the properties (@PropertySource above)
  @Autowired
  private Environment env;
  
  // We should log certain attributes. 
  private Logger logger = Logger.getLogger(getClass().getName());
  
  // define a bean for the ViewResolver.
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    
    return viewResolver;
  }
  
  // Define a bean for our security datasource
  @Bean
  public DataSource securityDataSource() {
    
    // create a connection pool
    ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        
    // set the jdbc driver class (requires a try-catch)
    try {
      securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
    } catch (PropertyVetoException e) {
      logger.severe(e.getLocalizedMessage());
      // e.printStackTrace();
      throw new RuntimeException(e);
    }
    
    // log the connection props
    logger.info("JDBC.URL=" + env.getProperty("jdbc.url"));
    logger.info("JDBC.USER=" + env.getProperty("jdbc.user"));
    
    // set database connection props
    securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
    securityDataSource.setUser(env.getProperty("jdbc.user"));
    securityDataSource.setPassword(env.getProperty("jdbc.password"));
    
    // set connection pool props
    securityDataSource.setInitialPoolSize(
        getProperty("connection.pool.initialPoolSize"));
    
    securityDataSource.setMinPoolSize(
        getProperty("connection.pool.minPoolSize"));

    securityDataSource.setMaxPoolSize(
        getProperty("connection.pool.maxPoolSize"));
    
    securityDataSource.setMaxIdleTime(
        getProperty("connection.pool.maxIdleTime"));    
    
    return securityDataSource;
  }
  
  public int getProperty(String propName) {
    try {
      return Integer.parseInt(env.getProperty(propName));
    } catch (final NumberFormatException e) {
      logger.severe(e.getLocalizedMessage());
      throw new RuntimeException(e);
    }
  }
}
