package com.hsa.queuescomparison.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisRdbConfiguration {

  @Value("spring.data.redis.hostname.rdb")
  private String hostname;


  @Bean(name = "jedisRdbConnectionFactory")
  JedisConnectionFactory jedisRdbConnectionFactory() {
    JedisConnectionFactory jedisConFactory
        = new JedisConnectionFactory();
    jedisConFactory.setHostName("localhost");
    jedisConFactory.setPort(6381);
    return jedisConFactory;
  }

  @Bean(name = "redisRdbTemplate")
  public RedisTemplate<String, Object> redisRdbTemplate() {
    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(jedisRdbConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    return template;
  }

}
