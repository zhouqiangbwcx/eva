package com.see.cloud.common.cahe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

import java.util.Collection;
import java.util.Collections;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisSessionDao extends AbstractSessionDAO {
	Logger log = LoggerFactory.getLogger(getClass());
	// Session超时时间，单位为毫秒
	private int expireTime = 7200000;

	@Autowired
	private JedisClient jedisClient;// redis缓存注入

	public void update(Session session) throws UnknownSessionException {
		log.info("更新seesion,id=[{}]", session.getId().toString());
		try {

			jedisClient.setex(session.getId().toString(), expireTime, serialize(session));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Session session) {
		log.info("删除seesion,id=[{}]", session.getId().toString());
		try {
			jedisClient.del(session.getId().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Collection<Session> getActiveSessions() {
		log.info("获取存活的session");
		return Collections.emptySet();
	}

	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		log.info("创建seesion,id=[{}]", session.getId().toString());
		try {
			jedisClient.setex(sessionId.toString(), expireTime, serialize(session));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return sessionId;
	}

	protected Session doReadSession(Serializable sessionId) {

		log.info("获取seesion,id=[{}]", sessionId.toString());
		Session session = null;
		try {
			session = (Session) deserialize(jedisClient.get(sessionId.toString()));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return session;
	}

	private static Object deserialize(String str) {
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(Base64.decode(str));
			ois = new ObjectInputStream(bis);
			return ois.readObject();
		} catch (Exception e) {
			throw new RuntimeException("deserialize session error", e);
		} finally {
			try {
				ois.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static String serialize(Object obj) {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			return Base64.encodeToString(bos.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("serialize session error", e);
		} finally {
			try {
				oos.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

}
