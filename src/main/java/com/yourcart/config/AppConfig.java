package com.yourcart.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yourcart")
@EnableTransactionManagement
@PropertySource({"classpath:Application.properties"})
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource appDataSource = new ComboPooledDataSource();
        try {
            appDataSource.setDriverClass("org.postgresql.Driver");
        }catch (PropertyVetoException exe){
            throw new RuntimeException(exe);
        }
        appDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        appDataSource.setUser(environment.getProperty("jdbc.user"));
        appDataSource.setPassword(environment.getProperty("jdbc.password"));
        appDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        appDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        appDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        appDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        return appDataSource;
    }


    private int getIntProperty(String propName) {
        return Integer.parseInt(Objects.requireNonNull(environment.getProperty(propName)));
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        return factory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txtManager = new HibernateTransactionManager();
        txtManager.setSessionFactory(sessionFactory);
        return txtManager;
    }
}
