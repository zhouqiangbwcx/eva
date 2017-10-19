package com.see.cloud;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@EnableTransactionManagement // 如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableEurekaClient // 启动EnableEureka客户端
@MapperScan("com.see.cloud.provider.sys.mapper")
public class PSysApplication implements CommandLineRunner {

	private final Logger logger = Logger.getLogger(PSysApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PSysApplication.class, args);
	}

	/**
	 * fasetJson
	 * 
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

	// springboot运行后此方法首先被调用
	// 实现CommandLineRunner抽象类中的run方法
	@Override
	public void run(String... args) throws Exception {
		logger.info("启动完成.............");
	}
}
