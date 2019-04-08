package com.example.jeedemo.jmsdemo;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

public class MessageDeliveryService {

    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/raas/eventqueue")
    private Queue inboundQueue;

    @Asynchronous
    public String handleEvent(final String name) {
        try (JMSContext ctx = connectionFactory.createContext()) {
            MessageDto object = new MessageDto("https://google.com", name);
            ObjectMessage message = ctx.createObjectMessage(object);
            JMSProducer producer = ctx.createProducer();
            for (int i =0;i<1000000000;i++){
                producer.send(inboundQueue, message);
            }
        }
        return name;
    }
}
