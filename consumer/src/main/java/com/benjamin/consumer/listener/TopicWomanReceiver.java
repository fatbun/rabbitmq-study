package com.benjamin.consumer.listener;
 
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;
 
/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@Component
@RabbitListener(queues = "topic.woman")
public class TopicWomanReceiver {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicWomanReceiver消费者收到消息  : " + testMessage.toString());
    }
}