package com.hsa.queuescomparison.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsa.queuescomparison.model.Message;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RdbMessageService {

  @Autowired
  @Qualifier("redisRdbTemplate")
  private RedisTemplate<String, Object> redisRdbTemplate;
  private Set<String> keys = new LinkedHashSet<>();

  public void putMessage() throws JsonProcessingException {
    String messageId = UUID.randomUUID().toString();
    Message user = new Message(messageId, "John");
    ObjectMapper objectMapper = new ObjectMapper();

    redisRdbTemplate.opsForValue().set(messageId, objectMapper.writeValueAsString(user));
    keys.add(messageId);
  }

  public Object getMessage() {

    String key = keys.stream().findFirst().orElse("");

    Object message = redisRdbTemplate.opsForValue().get(key);
    keys.remove(key);
    return message;
  }
}
