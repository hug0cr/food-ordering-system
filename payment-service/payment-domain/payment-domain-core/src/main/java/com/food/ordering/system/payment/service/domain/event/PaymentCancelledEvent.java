package com.food.ordering.system.payment.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCancelledEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCancelledEvent> paymentCancelledMessagePublisher;

    public PaymentCancelledEvent(Payment payment, ZonedDateTime createdAt,
                                 DomainEventPublisher<PaymentCancelledEvent> paymentCancelledMessagePublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCancelledMessagePublisher = paymentCancelledMessagePublisher;
    }

    @Override
    public void fire() {
        paymentCancelledMessagePublisher.publish(this);
    }
}
