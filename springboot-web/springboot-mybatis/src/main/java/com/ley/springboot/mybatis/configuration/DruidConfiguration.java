package com.ley.springboot.mybatis.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.ley.springboot.mybatis.constant.SpringbootMybatisConstants;

/**
 * Druid配置及其开启监控功能
 **/
@Configuration
public class DruidConfiguration {

	/**
	 * 控制台用户
	 **/
	private static final String LOGIN_USERNAME = "druid";

	private static final String LOGIN_PASSWORD = "12345";

	/**
	 * 访问的url
	 **/
	private static final String STATE_VIEW_SERVLET_URL_MAPPINGS = "/druid/*";
	
	/**
	 * 可忽略的拦截资源
	 * **/
	private static final String IGNORE_INTERCEPTOR_RESOURCE="*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,";
	
	private static final Logger logger=LoggerFactory.getLogger(DruidConfiguration.class);

	/**
	 * 配置监控服务器
	 *
	 * @return 返回监控注册的servlet对象
	 */
	@Bean(name="statViewServlet")
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				STATE_VIEW_SERVLET_URL_MAPPINGS);
		// 添加IP白名单
		servletRegistrationBean.addInitParameter("allow", SpringbootMybatisConstants.DRUID_WHITE_LIST);
		// 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
		servletRegistrationBean.addInitParameter("deny", SpringbootMybatisConstants.DRUID_BLACK_LIST);
		// 添加控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername", LOGIN_USERNAME);
		servletRegistrationBean.addInitParameter("loginPassword", LOGIN_PASSWORD);
		// 是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		logger.info("注入了bean:"+"statViewServlet");
		return servletRegistrationBean;
	}

	/**
	 * 配置服务过滤器
	 *
	 * @return 返回过滤器配置对象
	 */
	@Bean(name="statFilter")
	public FilterRegistrationBean statFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		// 添加过滤规则
		filterRegistrationBean.addUrlPatterns("/*");
		// 忽略过滤格式
		filterRegistrationBean.addInitParameter("exclusions",IGNORE_INTERCEPTOR_RESOURCE);
		logger.info("注入了bean: "+"statFilter");
		return filterRegistrationBean;
	}
}
