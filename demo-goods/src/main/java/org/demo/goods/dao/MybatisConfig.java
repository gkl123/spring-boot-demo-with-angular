package org.demo.goods.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration
public class MybatisConfig {
    @Value("${jdbc.url}")
    private static String jdbcUrl;
    
    @Value("${jdbc.username}")
    private static String jdbcUserName;
    
    @Value("${jdbc.password}")
    private static String jdbcPassword;
    
    @Value("${jdbc.driver-class-name}")
    private static String jdbcDriver;
    
    @Value("${mybatis.mapperLocations}")
    private static String mybatisMappingLocation;
    
    @Value("${mybatis.typeAliasesPackage}")
    private static String mybatisModelLocation;
    
    @Bean
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.put("driverClass", jdbcDriver);
        props.put("url", jdbcUrl);
        props.put("username", jdbcUserName);
        props.put("password", jdbcPassword);
        try {
            return DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
        ssf.setDataSource(ds);
        ssf.setTypeAliasesPackage(mybatisModelLocation);
        ssf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMappingLocation));
        return ssf.getObject();
    }

}
