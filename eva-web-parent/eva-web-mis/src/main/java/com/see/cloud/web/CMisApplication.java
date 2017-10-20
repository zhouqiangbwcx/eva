package com.see.cloud.web;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  // 启动EnableEureka客户端
@EnableHystrixDashboard//断路器
@EnableCircuitBreaker//断路器监控
public class CMisApplication implements CommandLineRunner {
	private final Logger logger = Logger.getLogger(CMisApplication.class);
 
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CMisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("启动完成！");
	}
}
