package com.food.ordering.system.payment.service.domain.value.object;

import com.food.ordering.system.domain.value.object.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
