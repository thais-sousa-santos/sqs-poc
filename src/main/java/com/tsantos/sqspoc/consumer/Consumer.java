package com.tsantos.sqspoc.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @SqsListener("process-payments")
    public void listen(ReceiverMessage message){
        System.out.println("Message received: " + message.data());
    }

}
