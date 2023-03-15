package com.food.ordering.system.domain.value.object;

import java.util.UUID;

public class ProductId extends BaseId<UUID> {
    protected ProductId(UUID value) {
        super(value);
    }
}
