package com.RedisCloudEx.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public <T> T get(Long key, Class<T> entity){
        try{
            Object o = redisTemplate.opsForValue().get(key.toString());
            if(o!=null){
                return objectMapper.readValue(o.toString(), entity);
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    public void set(Long key, Object o, Long ttl){
        try{
            String jsonVal = objectMapper.writeValueAsString(o);
            redisTemplate.opsForValue().set(key.toString(), jsonVal, ttl, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("Exception ",e);
        }
    }

}
