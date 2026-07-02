package com.spring.lifecycle.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

/**
 * CacheManager implementing Spring's lifecycle interfaces - InitializingBean:
 * implement afterPropertiesSet() - DisposableBean: implement destroy()
 */
public class CacheManager implements InitializingBean, DisposableBean {

    private String cacheName;
    private int cacheSize;
    private int itemCount = 0;

    public CacheManager() {
        System.out.println("[CacheManager] Constructor called");
    }

    public void setCacheName(String cacheName) {
        System.out.println("[CacheManager] setCacheName: " + cacheName);
        this.cacheName = cacheName;
    }

    public void setCacheSize(int cacheSize) {
        System.out.println("[CacheManager] setCacheSize: " + cacheSize);
        this.cacheSize = cacheSize;
    }

    /**
     * afterPropertiesSet() called after all properties are set
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[CacheManager] ✓ afterPropertiesSet() called");
        System.out.println("  - Initializing cache: " + cacheName);
        System.out.println("  - Cache size: " + cacheSize);
        System.out.println("  - Warming up cache...");
        System.out.println("  - Cache ready");
    }

    /**
     * destroy() called when container closes
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("[CacheManager] ✓ destroy() called");
        System.out.println("  - Flushing " + itemCount + " items from cache");
        System.out.println("  - Releasing cache resources...");
        System.out.println("  - Cache cleaned up");
    }

    public void putItem(String key, String value) {
        if (itemCount < cacheSize) {
            itemCount++;
            System.out.println("[CacheManager] Item cached: " + key + " = " + value + " (Total: " + itemCount + ")");
        } else {
            System.out.println("[CacheManager] Cache full! Cannot add: " + key);
        }
    }

    public String getItem(String key) {
        System.out.println("[CacheManager] Retrieving: " + key);
        return "value_for_" + key;
    }
}
