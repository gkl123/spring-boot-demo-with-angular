package org.demo.web.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 需要配置拦截请求url的时候才启用
 * @author yss
 *
 */
//@Configuration//添加此注解,标识这是一个配置类
public class WebConfiguration {

//    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

//    @Bean
    public FilterRegistrationBean testFilterRegistrationBean() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName", "value");
        registrationBean.setName("corsFilter");
        registrationBean.setOrder(1);
        
        return registrationBean;
    }


}