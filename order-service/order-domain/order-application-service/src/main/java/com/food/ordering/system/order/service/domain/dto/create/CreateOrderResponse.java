package com.food.ordering.system.order.service.domain.dto.create;

import com.food.ordering.system.domain.value.object.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NonNull
    private final UUID orderTrackId;
    @NonNull
    private final OrderStatus orderStatus;
    @NonNull
    private final String message;
}
