package com.frost.forest.pen.bean.config;

/**
 * Created by wenkui on 2015/3/13.
 */


import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wenkui on 2015/3/13.
 */

@Configuration
@PropertySource("classpath:global.properties")
@Order(1)
public class DataConfig {


    final static Logger logger = LoggerFactory.getLogger(DataConfig.class);



    private static final String DATABASE_DRIVER = "db.driver";
    private static final String DATABASE_PASSWORD = "db.password";
    private static final String DATABASE_URL = "db.url";
    private static final String DATABASE_USERNAME = "db.username";

    private static final String DIALECT = "hibernate.dialect";
    private static final String FORMAT_SQL = "hibernate.format_sql";
    private static final String NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String SHOW_SQL = "hibernate.show_sql";
    private static final String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Resource
    private Environment environment;
    @Autowired
    private DataSource dataSource;


    @Bean
    public DataSource dataSource() throws IOException {
        System.out.println("init dataSource!");
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(environment
                .getRequiredProperty(DATABASE_DRIVER));
        druidDataSource.setUrl(environment
                .getRequiredProperty(DATABASE_URL));
        druidDataSource.setUsername(environment
                .getRequiredProperty(DATABASE_USERNAME));
        druidDataSource.setPassword(environment
                .getRequiredProperty(DATABASE_PASSWORD));
        druidDataSource.setTestWhileIdle(true);
        return druidDataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(environment
                .getRequiredProperty(PACKAGES_TO_SCAN));
        emf.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter());
        Properties jpaProterties = new Properties();
        jpaProterties.put(DIALECT, environment
                .getRequiredProperty(DIALECT));
        jpaProterties.put(FORMAT_SQL, environment
                .getRequiredProperty(FORMAT_SQL));
        jpaProterties.put(NAMING_STRATEGY, environment
                .getRequiredProperty(NAMING_STRATEGY));
        jpaProterties.put(SHOW_SQL, environment
                .getRequiredProperty(SHOW_SQL));
        jpaProterties.put(HBM2DDL_AUTO, environment
                .getRequiredProperty(HBM2DDL_AUTO));
        emf.setJpaProperties(jpaProterties);
        return emf;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager( LocalContainerEntityManagerFactoryBean entityManagerFactory)
            throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}

