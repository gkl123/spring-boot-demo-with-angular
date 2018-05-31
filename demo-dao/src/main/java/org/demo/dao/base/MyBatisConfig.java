package org.demo.dao.base;

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
public class MyBatisConfig {
	
    
    @Value("${jdbc.driver-class-name}")
    private String jdbcDriverClassName;
    
    @Value("${jdbc.url}")
    private String jdbcUrl;
    
    @Value("${jdbc.username}")
    private String jdbcUsername;
    
    @Value("${jdbc.password}")
    private String jdbcPassword;
    
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage = "classpath:org/demo/model/po";
    
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations = "classpath:org/demo/dao/mapper/mapping/*.xml";
    

    /**  
    * @Title: getDataSource  
    * @Description: 创建数据源 
    * @param @return 
    * @return DataSource
    * @throws  
    */  
    @Bean
    public DataSource getDataSource(){
        Properties props = new Properties();
        props.put("driverClass", jdbcDriverClassName);
        props.put("url", jdbcUrl);
        props.put("username", jdbcUsername);
        props.put("password", jdbcPassword);
        try {
            return DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**  
    * @Title: sqlSessionFactory  
    * @Description:  根据数据源创建SqlSessionFactory 
    * @param @param ds
    * @param @return
    * @param @throws Exception 
    * @return SqlSessionFactory
    * @throws  
    */  
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(ds);
        sfb.setTypeAliasesPackage(typeAliasesPackage);
        sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return sfb.getObject();
    }

}
