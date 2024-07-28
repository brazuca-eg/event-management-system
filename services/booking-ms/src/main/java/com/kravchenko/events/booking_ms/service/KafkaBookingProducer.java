package com.kravchenko.events.booking_ms.service;

import com.kravchenko.events.booking_ms.dto.request.BookingRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaBookingProducer {

    private final KafkaTemplate<String, BookingRequest> kafkaTemplate;

    public KafkaBookingProducer(KafkaTemplate<String, BookingRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBookingConfirmation(BookingRequest bookingRequest){
        Message<BookingRequest> bookingMessage = MessageBuilder
                .withPayload(bookingRequest)
                .setHeader(KafkaHeaders.TOPIC, "booking-topic")
                .build();

        kafkaTemplate.send(bookingMessage);

    }
}
