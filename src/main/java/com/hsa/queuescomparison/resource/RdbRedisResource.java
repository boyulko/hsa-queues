package com.hsa.queuescomparison.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsa.queuescomparison.service.RdbMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rdb-redis")
@RequiredArgsConstructor
public class RdbRedisResource {

  private final RdbMessageService rdbMessageService;

  @PostMapping
  public ResponseEntity<Long> putMessageInQueue() throws JsonProcessingException {
    rdbMessageService.putMessage();
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<?> getMessage() {
    return ResponseEntity.ok(rdbMessageService.getMessage());
  }

}
