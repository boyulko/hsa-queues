package com.hsa.queuescomparison.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisAofConfiguration {

  @Value("spring.data.redis.hostname.aof")
  private String hostname;


  @Bean(name = "jedisAofConnectionFactory")
  JedisConnectionFactory jedisAofConnectionFactory() {
    JedisConnectionFactory jedisConFactory
        = new JedisConnectionFactory();
    jedisConFactory.setHostName("localhost");
    jedisConFactory.setPort(6380);
    return jedisConFactory;
  }

  @Bean(name="redisAofTemplate")
  public RedisTemplate<String, Object> redisAofTemplate() {
    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(jedisAofConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    return template;
  }

  @Bean(name = "jedisConnectionFactory")
  JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConFactory
        = new JedisConnectionFactory();
//    jedisConFactory.setHostName("localhost");
//    jedisConFactory.setPort(6380);
    return jedisConFactory;
  }

  @Bean(name="redisTemplate")
  public RedisTemplate<String, Object> redisTemplate() {
    final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(jedisAofConnectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    return template;
  }

}
