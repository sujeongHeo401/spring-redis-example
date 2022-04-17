package com.example.cache.springredisexample;

import com.example.cache.springredisexample.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisExampleApplication {
	private @Value("${spring.redis.host}") String redisHost;
	private @Value("${spring.redis.port}") int redisPort;
	@Bean
	JedisConnectionFactory  jedisConnectionFactory() {
		jedisConnectionFactory().setHostName(redisHost);
		jedisConnectionFactory().setPort(redisPort);
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate(){
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}

}
