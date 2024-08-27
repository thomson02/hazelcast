package com.example.hazelcastdemo.controller;

import com.example.hazelcastdemo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable String key) {
        String value = cacheService.getValue(key);
        return value != null ? value : "Key not found!";
    }

    @PostMapping("/update")
    public String updateValue(@RequestParam String key, @RequestParam String value) {
        cacheService.updateValue(key, value);
        return "Value updated!";
    }
}
