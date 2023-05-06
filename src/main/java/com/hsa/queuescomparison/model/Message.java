package com.hsa.queuescomparison.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Builder;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Message implements Serializable {

  @JsonProperty
  String id;

  @JsonProperty
  String text;

  public Message(String id, String text) {
    this.id = id;
    this.text = text;
  }

  public Message() {
  }
}
