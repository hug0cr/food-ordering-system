package com.food.ordering.system.order.service.domain.value.object;

import com.food.ordering.system.domain.value.object.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
