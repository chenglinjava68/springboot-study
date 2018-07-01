package com.ley.springboot.redis.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.ley.springboot.redis.configuration.properties.RedisPoolProperties;
import com.ley.springboot.redis.configuration.properties.SimpleRedisProperties;
import com.ley.springboot.redis.utils.RedisUtils;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource(value = "classpath:config/redis.properties")
@EnableConfigurationProperties(value={RedisPoolProperties.class,SimpleRedisProperties.class})
public class RedisConfiguration {

	@Autowired
	private RedisPoolProperties redisPoolProperties;
	
	@Autowired
	private SimpleRedisProperties simpleRedisProperties;
	
	/*
	 * @Value("${spring.redis.cluster.nodes}") private String clusterNodes;
	 * 
	 * @Value("${spring.redis.cluster.max-redirects}") private Integer
	 * mmaxRedirectsac;
	 */

	/**
	 * JedisPoolConfig 连接池配置Bean
	 * 
	 * @return {@link JedisPoolConfig}
	 */
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		System.out.println(redisPoolProperties);
		// 最大空闲数
		jedisPoolConfig.setMaxIdle(redisPoolProperties.getMaxIdle());
		// 连接池的最大数据库连接数
		jedisPoolConfig.setMaxTotal(redisPoolProperties.getMaxTotal());
		// 最大建立连接等待时间
		jedisPoolConfig.setMaxWaitMillis(redisPoolProperties.getMaxWaitMillis());
		// 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
		jedisPoolConfig.setMinEvictableIdleTimeMillis(redisPoolProperties.getMinEvictableIdleTimeMillis());
		// 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
		jedisPoolConfig.setNumTestsPerEvictionRun(redisPoolProperties.getNumTestsPerEvictionRun());
		// 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(redisPoolProperties.getMinEvictableIdleTimeMillis());
		// 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
		jedisPoolConfig.setTestOnBorrow(redisPoolProperties.isTestOnBorrow());
		// 在空闲时检查有效性, 默认false
		jedisPoolConfig.setTestWhileIdle(redisPoolProperties.isTestWhileIdle());
		return jedisPoolConfig;
	}

	/**
	 * 单机版配置
	 */
	@Bean
	public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
		// 连接池
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		// IP地址
		jedisConnectionFactory.setHostName(simpleRedisProperties.getHostName());
		// 端口号
		jedisConnectionFactory.setPort(simpleRedisProperties.getPort());
		// 如果Redis设置有密码
		// JedisConnectionFactory.setPassword(password);
		// 客户端超时时间单位是毫秒
		jedisConnectionFactory.setTimeout(simpleRedisProperties.getTimeout());
		// 设置存储的database
		jedisConnectionFactory.setDatabase(simpleRedisProperties.getDatabase());
		System.out.println(simpleRedisProperties);
		return jedisConnectionFactory;
	}

	/**
	 * 实例化 RedisTemplate 对象
	 *
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
		return redisTemplate;
	}

	/**
	 * 设置数据存入 redis 的序列化方式,并开启事务
	 * 
	 * @param redisTemplate
	 * @param factory
	 */
	private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
		// 如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast
		// to String！
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		// 开启事务
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.setConnectionFactory(factory);
	}

	/**
	 * redis utility class
	 **/
	@Bean
	public RedisUtils redisUtil(RedisTemplate<String, Object> redisTemplate) {
		RedisUtils redisUtil = new RedisUtils();
		redisUtil.setRedisTemplate(redisTemplate);
		return redisUtil;
	}

}