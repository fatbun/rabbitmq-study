package com.benjamin.consumer.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = "direct.queue")//监听的队列名称
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage, Channel channel, Message message) throws IOException {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
//        channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}