package com.ley.springboot.redis.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="redis")
@Component
public class RedisPoolProperties {

	/**
	 * 连接池最大空闲数
	 * **/
	private Integer maxIdle;

	/**
	 * 连接池的最大数据库连接数
	 * **/
	private Integer maxTotal;

	/**
	 * 最大建立连接等待时间
	 * **/
	private Integer maxWaitMillis;
	
	/**
	 * 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
	 * **/
	private Integer minEvictableIdleTimeMillis;

	/**
	 * 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
	 * **/
	private Integer numTestsPerEvictionRun;

	/**
	 * 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
	 * **/
	private long timeBetweenEvictionRunsMillis;

	/**
	 * 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
	 * **/
	private boolean testOnBorrow;

	/**
	 * 在空闲时检查有效性, 默认false
	 * **/
	private boolean testWhileIdle;

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

	public Integer getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Integer maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public Integer getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public Integer getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	public long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	@Override
	public String toString() {
		return "JedisPoolProperties [maxIdle=" + maxIdle + ", maxTotal=" + maxTotal + ", maxWaitMillis=" + maxWaitMillis
				+ ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis + ", numTestsPerEvictionRun="
				+ numTestsPerEvictionRun + ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis
				+ ", testOnBorrow=" + testOnBorrow + ", testWhileIdle=" + testWhileIdle + "]";
	}
	
	
}
