package org.demo.dao.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisPoolConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
  
/** 
 * Created by rick on 2017/12/16. 
 */  
@Configuration  
@EnableCaching  
public class RedisConfig extends CachingConfigurerSupport {  
    
    @Value("${spring.redis.host}")
    private String host;
    
    @Value("${spring.redis.port}")
    private int port;
    
    @Value("${spring.redis.password}")
    private String password;
    
    @Value("${spring.redis.timeout}")
    private int timeout;
    
    @Autowired  
    RedisTemplate<String, Object> redisTemplate;  
    
    private static Logger logger = Logger.getLogger(RedisConfig.class);  
    
    @Bean  
//    @Override  
    public KeyGenerator keyGenerator() {  
        return new KeyGenerator() {  
//            @Override  
            public Object generate(Object target, Method method, Object... params) {  
                StringBuilder sb = new StringBuilder();  
                sb.append(target.getClass().getName());  
                sb.append(method.getName());  
                for (Object obj : params) {  
                    sb.append(obj.toString());  
                }  
                return sb.toString();  
            }  
        };  
    }  
    
    @SuppressWarnings("rawtypes")  
    @Bean  
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);  
        //设置缓存过期时间  
        //rcm.setDefaultExpiration(60);//秒  
        return rcm;  
    }  
    
    @Bean  
    public ValueOperations<String,Object> vos(){  
        return redisTemplate.opsForValue();  
    }  
    
    

    /**
    * redis 数据库连接池
    * @return
    */
    
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setPassword(password);
        factory.setTimeout(timeout); // 设置连接超时时间
        factory.setPoolConfig(new JedisPoolConfig());
        return factory;
    }
    
    
//    /**
//    * redisTemplate配置
//    *
//    * @param factory
//    * @return
//    */
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        
//        return template;
//    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
        template.setKeySerializer(new StringRedisSerializer());//指定key的序列化
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }
    
}  