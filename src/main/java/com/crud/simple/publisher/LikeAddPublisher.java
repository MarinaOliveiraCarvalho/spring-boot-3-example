package com.crud.simple.publisher;

import com.crud.simple.dto.PublishingAddLikeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LikeAddPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${api.rabbitmq.publishing.add-like.exchange}")
    private String exchange;

    @Value("${api.rabbitmq.publishing.add-like.routing}")
    private String routing;

    public void send(PublishingAddLikeDto publishingAddLikeDto) {
        try {
            rabbitTemplate.convertAndSend(exchange, routing, publishingAddLikeDto);
            log.info("New event send of add Like");
        }catch ( RuntimeException e){
            log.info("ERROR send event publishingAddLikeDto {}, type {}, message {}", publishingAddLikeDto);
            throw new RuntimeException(e);
        }
    }
}
