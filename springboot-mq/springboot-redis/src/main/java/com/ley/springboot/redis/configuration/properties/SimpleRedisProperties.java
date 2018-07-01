package com.ley.springboot.redis.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="redis")
@Component
public class SimpleRedisProperties {

	private String hostName;
	
	private int port;
	
	private int timeout;
	
	private int database;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	@Override
	public String toString() {
		return "RedisProperties [hostName=" + hostName + ", port=" + port + ", timeout=" + timeout + ", database="
				+ database + "]";
	}
	
}
