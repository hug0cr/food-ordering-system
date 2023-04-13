package com.food.ordering.system.restaurant.service.domain.value.object;

import com.food.ordering.system.domain.value.object.BaseId;

import java.util.UUID;

public class OrderApprovalId extends BaseId<UUID> {
    public OrderApprovalId(UUID value) {
        super(value);
    }
}
