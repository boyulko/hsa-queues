package com.hsa.queuescomparison.service;

import com.dinstone.beanstalkc.JobConsumer;
import com.dinstone.beanstalkc.JobProducer;
import com.hsa.queuescomparison.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

@Service
@RequiredArgsConstructor
public class BeanstalkdMessageService {

  private final JobProducer jobProducer;
  private final JobConsumer jobConsumer;

  public long putMessage() {

    Message message = new Message("1", "text");
    byte[] serialized = SerializationUtils.serialize(message);
    return jobProducer.putJob(0, 0, 0, serialized);
  }

  public byte[] readMessage() {
    return jobConsumer.reserveJob(2).getData();
  }
}
