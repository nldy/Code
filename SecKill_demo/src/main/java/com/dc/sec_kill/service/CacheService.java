package com.dc.sec_kill.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 缓存接口
 */
public interface CacheService {

    /**
     * 从缓存中获取 key 值对应的 value
     *
     * @param key
     * @return
     */
    Optional<Object> get(String key);

    /**
     * 以 key-value 形式保存数据到缓存
     *
     * @param key
     * @param value
     */
    void put(String key, Object value);

    /**
     * 以 key-value 形式保存数据到缓存，并设置其有效时长
     *
     * @param key
     * @param value
     * @param timeOut
     * @param unit
     */
    void put(String key, Object value, long timeOut, TimeUnit unit);

    /**
     * 删除缓存中的数据
     *
     * @param key
     */
    void remove(String key);

}
