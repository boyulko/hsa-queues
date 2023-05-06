package com.hsa.queuescomparison.configuration;

import com.dinstone.beanstalkc.BeanstalkClientFactory;
import com.dinstone.beanstalkc.JobConsumer;
import com.dinstone.beanstalkc.JobProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

  @Bean
  public JobProducer jobProducer() {
    return factory().createJobProducer("pctube");
  }

  @Bean
  public JobConsumer jobConsumer() {
    return factory().createJobConsumer("pctube");
  }

  @Bean
  public BeanstalkClientFactory factory() {
    com.dinstone.beanstalkc.Configuration config = new com.dinstone.beanstalkc.Configuration();
    config.setServiceHost("127.0.0.1");
    config.setServicePort(11300);
    config.setConnectTimeout(2000);
    config.setReadTimeout(3000);

    return new BeanstalkClientFactory(config);
  }

}
