package org.eapol.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ConsumerApplication {
  private final Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

  @KafkaListener(topics = "messages", id = "group_id")
  public void listen(String message) {
    logger.info(message);
  }

}
