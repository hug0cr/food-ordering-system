package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {

    private final DomainEventPublisher<OrderCancelledEvent> orderCancelledMessagePublisher;

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderCancelledEvent> orderCancelledMessagePublisher) {
        super(order, createdAt);
        this.orderCancelledMessagePublisher = orderCancelledMessagePublisher;
    }

    @Override
    public void fire() {
        orderCancelledMessagePublisher.publish(this);
    }
}
