package com.hsa.queuescomparison.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsa.queuescomparison.service.AofMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aof-redis")
@RequiredArgsConstructor
public class AofRedisResource {

  private final AofMessageService aofMessageService;

  @PostMapping
  public ResponseEntity<Long> putMessageInQueue() throws JsonProcessingException {
    aofMessageService.putMessage();
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<?> getMessage() {
    return ResponseEntity.ok(aofMessageService.getMessage());
  }

}
