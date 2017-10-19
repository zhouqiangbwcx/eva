package com.see.cloud.common.cahe;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool jedisPool;

	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}

	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}

	public String setex(String key, int seconds, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.setex(key, seconds, value);
		jedis.close();
		return result;
	}

	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: hkeys
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param bytes
	 * @return
	 * @see com.Common.common.cache.JedisClient#hkeys(byte[])
	 */
	public Set<byte[]> hkeys(byte[] bytes) {
		Jedis jedis = jedisPool.getResource();
		Set<byte[]> result = jedis.hkeys(bytes);
		jedis.close();
		return result;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: flushDB
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @see com.Common.common.cache.JedisClient#flushDB()
	 */
	public String flushDB() {
		/*
		 * Jedis jedis = jedisPool.getResource(); String result =
		 * jedis.flushDB(); jedis.close(); return result;
		 */

		return null;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: dbSize
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.Common.common.cache.JedisClient#dbSize()
	 */
	public Long dbSize() {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.dbSize();
		jedis.close();
		return result;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: get
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param key
	 * @return
	 * @see com.Common.common.cache.JedisClient#get(byte[])
	 */
	public byte[] get(byte[] key) {
		Jedis jedis = jedisPool.getResource();
		byte[] result = jedis.get(key);
		jedis.close();
		return result;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: set
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @see com.Common.common.cache.JedisClient#set(byte[], byte[])
	 */
	public String set(byte[] key, byte[] value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: del
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param key
	 * @return
	 * @see com.Common.common.cache.JedisClient#del(byte[])
	 */
	public Long del(byte[] key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	public long pttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.pttl(key);
		jedis.close();
		return result;
	}

}
