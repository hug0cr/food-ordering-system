package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent {

    private final DomainEventPublisher<OrderCreatedEvent> orderCreatedMessagePublisher;

    public OrderCreatedEvent(Order order, ZonedDateTime createdAt,
                             DomainEventPublisher<OrderCreatedEvent> orderCreatedMessagePublisher) {
        super(order, createdAt);
        this.orderCreatedMessagePublisher = orderCreatedMessagePublisher;
    }

    @Override
    public void fire() {
        orderCreatedMessagePublisher.publish(this);
    }
}
