package com.dc.sec_kill.service.impl;

import com.dc.sec_kill.service.CacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
//import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 缓存实现类 - Redis 方式缓存
 */
public class RedisCacheServiceImpl implements CacheService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static Cache<String, Object> CACHE = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(30, TimeUnit.DAYS)
            .concurrencyLevel(10)
            .build();
    private final RedisTemplate<String, Object> redisTemplate;
    private final static String KEY_PREFIX = "PCO";

    public RedisCacheServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<Object> get(String key) {
        if (StringUtils.isBlank(key)) {
//            log.error("cache key is blank");
            logger.error("cache key is blank");
            throw new NullPointerException("cache key is blank");
        }
        Object value = this.redisTemplate.opsForValue().get(KEY_PREFIX + key);
        return Optional.ofNullable(value);
    }

    @Override
    public void put(String key, Object value) {
        if (StringUtils.isBlank(key) || value == null) {
//            log.error("cache error " + key + ":" + value);
            logger.error("cache error " + key + ":" + value);
            throw new NullPointerException("cache error either key or object is invalid");
        }
        redisTemplate.opsForValue().set(KEY_PREFIX + key, value, 60, TimeUnit.MINUTES);
    }

    @Override
    public void put(String key, Object value, long timeOut, TimeUnit unit) {
        if (StringUtils.isBlank(key) || value == null) {
//            log.error("cache error " + key + ":" + value);
            logger.error("cache error " + key + ":" + value);
            throw new NullPointerException("cache error either key or object is invalid");
        }
        redisTemplate.opsForValue().set(KEY_PREFIX + key, value, timeOut, unit);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(KEY_PREFIX + key);
    }
}
