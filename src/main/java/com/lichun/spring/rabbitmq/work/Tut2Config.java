package com.lichun.spring.rabbitmq.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Tut2Config {

    @Profile("workqueue")
    @Bean
    public Queue workQueue() {
        return new Queue("work-queue");
    }

    @Profile("sender2")
    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }

    @Profile("receiver2")
    private static class ReceiverConfig {

        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }
}
