package com.example.hazelcastdemo.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final IMap<String, String> cacheMap;

    @Autowired
    public CacheService(HazelcastInstance hazelcastInstance) {
        this.cacheMap = hazelcastInstance.getMap("myCache");
    }

    public String getValue(String key) {
        return cacheMap.get(key);
    }

    public void updateValue(String key, String value) {
        cacheMap.put(key, value);
    }
}
