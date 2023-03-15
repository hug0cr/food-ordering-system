package com.food.ordering.system.domain.value.object;

import java.util.UUID;

public class RestaurantId extends BaseId<UUID> {
    protected RestaurantId(UUID value) {
        super(value);
    }
}
