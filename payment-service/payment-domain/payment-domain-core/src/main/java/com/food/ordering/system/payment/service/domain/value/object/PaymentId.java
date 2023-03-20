package com.food.ordering.system.payment.service.domain.value.object;

import com.food.ordering.system.domain.value.object.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
