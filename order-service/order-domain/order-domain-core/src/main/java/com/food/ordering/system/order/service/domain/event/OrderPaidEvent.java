package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {

    private final DomainEventPublisher<OrderPaidEvent> orderPaidMessagePublisher;

    public OrderPaidEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderPaidEvent> orderPaidMessagePublisher) {
        super(order, createdAt);
        this.orderPaidMessagePublisher = orderPaidMessagePublisher;
    }

    @Override
    public void fire() {
        orderPaidMessagePublisher.publish(this);
    }
}
