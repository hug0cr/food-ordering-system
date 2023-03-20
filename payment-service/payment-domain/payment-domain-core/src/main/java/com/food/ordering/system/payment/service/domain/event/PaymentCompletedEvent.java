package com.food.ordering.system.payment.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCompletedEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCompletedEvent> paymentCompletedMessagePublisher;

    public PaymentCompletedEvent(Payment payment,
                                 ZonedDateTime createdAt,
                                 DomainEventPublisher<PaymentCompletedEvent> paymentCompletedMessagePublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCompletedMessagePublisher = paymentCompletedMessagePublisher;
    }

    @Override
    public void fire() {
        paymentCompletedMessagePublisher.publish(this);
    }
}
