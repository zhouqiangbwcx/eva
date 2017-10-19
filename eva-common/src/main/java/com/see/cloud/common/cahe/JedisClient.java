package com.see.cloud.common.cahe;

import java.util.Set;

public interface JedisClient {

	String get(String key);

	String set(String key, String value);

	String hget(String hkey, String key);

	long hset(String hkey, String key, String value);

	long incr(String key);

	long expire(String key, int second);

	long ttl(String key);

	long del(String key);

	long pttl(String key);

	long hdel(String hkey, String key);

	Set<byte[]> hkeys(byte[] bytes);

	// 不容许情况数据库
	String flushDB();

	Long dbSize();

	byte[] get(byte[] key);

	String set(byte[] key, byte[] value);

	String setex(final String key, final int seconds, final String value);

	Long del(byte[] key);
}
