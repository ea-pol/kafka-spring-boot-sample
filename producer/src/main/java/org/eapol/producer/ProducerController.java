package org.eapol.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api")
public class ProducerController {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @PostMapping("/messages")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void sendMessage(@RequestBody String message) {
    kafkaTemplate.send("messages", message);
  }
}
