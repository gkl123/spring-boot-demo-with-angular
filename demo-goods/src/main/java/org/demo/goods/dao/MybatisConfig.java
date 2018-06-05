package org.demo.goods.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration
public class MybatisConfig {
    private static String jdbcUrl;
    
    private static String jdbcUserName;
    
    private static String jdbcPassword;
    
    private static String jdbcDriver;
    
    private static String mybatisMappingLocation;
    
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
