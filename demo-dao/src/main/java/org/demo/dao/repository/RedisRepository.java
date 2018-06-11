package org.demo.dao.repository;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
    private Logger logger = Logger.getLogger(RedisRepository.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
    * 批量删除对应的value
    *
    * @param keys
    */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
    * 批量删除key
    *
    * @param pattern
    */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
    * 删除对应的value
    *
    * @param key
    */
    @SuppressWarnings("unchecked")
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
    * 判断缓存中是否有对应的value
    *
    * @param key
    * @return
    */
    @SuppressWarnings("unchecked")
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
    * 读取缓存
    *
    * @param key
    * @return
    */
    @SuppressWarnings("unchecked")
        public Object get(final String key) {
        Object result = null;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
    * 写入缓存
    *
    * @param key
    * @param value
    * @return
    */
    @SuppressWarnings("unchecked")
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
    * 写入缓存
    *
    * @param key
    * @param value
    * @return
    */
    @SuppressWarnings("unchecked")
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @param mode 是否使用set if not exist ：true为使用模式，不传值或者穿false则不使用；
     * @return
     */
     @SuppressWarnings("unchecked")
     public boolean set(final String key, Object value, Long expireTime, Boolean mode) {
         boolean result = false;
         if (mode == null) {
             // 给mode默认值
             mode = false;
         }
         try {
             ValueOperations<String, Object> operations = redisTemplate.opsForValue();
             if(mode && operations.get(key) != null){
                // 如果鍵值已存在则无法插入同样key的数据
                return result;
             }
             operations.set(key, value);
             redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
             result = true;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return result;
     }
}
