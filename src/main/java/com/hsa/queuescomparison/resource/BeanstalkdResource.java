package com.hsa.queuescomparison.resource;

import com.hsa.queuescomparison.service.BeanstalkdMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beanstalkd")
@RequiredArgsConstructor
public class BeanstalkdResource {

  private final BeanstalkdMessageService beanstalkdMessageService;

  @PostMapping
  public ResponseEntity<Long> putMessageInQueue() {
    return ResponseEntity.ok(beanstalkdMessageService.putMessage());
  }

  @GetMapping
  public ResponseEntity<?> getMessages() {
    return ResponseEntity.ok(beanstalkdMessageService.readMessage());
  }

}
