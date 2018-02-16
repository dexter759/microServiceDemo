package com.brokflok.demomicro.kafka.consumer;

import com.brokflok.demomicro.entity.Task;
import com.brokflok.demomicro.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(2);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.bar}")
  public void receiveBar(Task bar) {
    LOGGER.info("received {}", bar);
    latch.countDown();
  }

  @KafkaListener(topics = "${kafka.topic.foo}")
  public void receiveFoo(User foo) {
    LOGGER.info("received {}", foo);
    latch.countDown();
  }
  @KafkaListener(topics = "${kafka.topic.send}")
  public void receive(Task task){
    LOGGER.info("received {} {}", task.getDesc(), task.isDone());
    latch.countDown();
  }
  @KafkaListener(topics = "${kafka.topic.back}")
  public void receiveback(Task task){
    LOGGER.info("received {} {}", task.getDesc(), task.isDone());
    latch.countDown();
  }

}
