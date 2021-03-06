package com.see.cloud.web.common.cahe;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.see.cloud.core.common.cahe.JedisClient;
import com.see.cloud.core.common.cahe.RedisCache;

@Component
public class RedisCacheManager implements CacheManager {
	@Autowired
	private JedisClient jedisClient;// redis缓存注入

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		System.out.println("name:" + name);
		return new RedisCache<K, V>(jedisClient);// 为了简化代码的编写，此处直接new一个Cache
	}

}