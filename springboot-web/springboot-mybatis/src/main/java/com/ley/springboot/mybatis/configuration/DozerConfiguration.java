package com.ley.springboot.mybatis.configuration;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ley.springboot.mybatis.utils.BeanMapper;

/**
 * 各个模块的dozer配置文件
 */
@Configuration
@ConditionalOnClass({ DozerBeanMapper.class, org.dozer.Mapper.class })
public class DozerConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(DozerConfiguration.class);
	

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozer() {
		List<String> mappingFiles = Arrays.asList("dozer-config.xml");
		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		logger.info("注入了bean"+"org.dozer.Mapper");
		return dozerBean;
	}
	
	@Bean(name="beanMapper")
	public BeanMapper BeanMapper(){
		logger.info("注入了bean"+" beanMapper");
		return new BeanMapper();
	}
}
