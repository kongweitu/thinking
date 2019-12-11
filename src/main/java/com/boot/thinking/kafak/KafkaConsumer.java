package com.boot.thinking.kafak;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    /*@KafkaListener(topics ="test", groupId ="noc")
    public void consumer(ConsumerRecord<String, String> record, Consumer consumer)throws Exception{
        String data =record.value();
        System.out.println("++++++++++++++:"+data);
        consumer.commitAsync();
    }
*/
}
