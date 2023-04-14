package com.food.ordering.system.restaurant.service.messaging.mapper;

import com.food.ordering.system.domain.value.object.ProductId;
import com.food.ordering.system.domain.value.object.RestaurantOrderStatus;
import com.food.ordering.system.kafka.order.avro.model.OrderApprovalStatus;
import com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.food.ordering.system.restaurant.service.domain.entity.Product;
import com.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;
import com.food.ordering.system.restaurant.service.domain.event.OrderRejectedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestaurantMessagingDataMapper {

    public RestaurantApprovalResponseAvroModel orderApprovedEventToRestaurantApprovalResponseAvroModel(
            OrderApprovedEvent orderApprovedEvent) {
        return RestaurantApprovalResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrderId(orderApprovedEvent.getOrderApproval().getOrderId().getValue().toString())
                .setRestaurantId(orderApprovedEvent.getRestaurantId().getValue().toString())
                .setCreatedAt(orderApprovedEvent.getCreatedAt().toInstant())
                .setOrderApprovalStatus(OrderApprovalStatus.valueOf(
                        orderApprovedEvent.getOrderApproval().getApprovalStatus().name()))
                .setFailureMessages(orderApprovedEvent.getFailureMessages())
                .build();
    }

    public RestaurantApprovalResponseAvroModel orderRejectedEventToRestaurantApprovalResponseAvroModel(
            OrderRejectedEvent orderRejectedEvent) {
        return RestaurantApprovalResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setOrderId(orderRejectedEvent.getOrderApproval().getOrderId().getValue().toString())
                .setRestaurantId(orderRejectedEvent.getRestaurantId().getValue().toString())
                .setCreatedAt(orderRejectedEvent.getCreatedAt().toInstant())
                .setOrderApprovalStatus(OrderApprovalStatus.valueOf(orderRejectedEvent
                        .getOrderApproval().getApprovalStatus().name()))
                .setFailureMessages(orderRejectedEvent.getFailureMessages())
                .build();
    }

    public RestaurantApprovalRequest restaurantApprovalRequestAvroModelToRestaurantApprovalRequest(
            RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel) {
        return RestaurantApprovalRequest.builder()
                .id(restaurantApprovalRequestAvroModel.getId())
                .sagaId(restaurantApprovalRequestAvroModel.getSagaId())
                .restaurantId(restaurantApprovalRequestAvroModel.getRestaurantId())
                .orderId(restaurantApprovalRequestAvroModel.getOrderId())
                .restaurantOrderStatus(RestaurantOrderStatus.valueOf(restaurantApprovalRequestAvroModel
                        .getRestaurantOrderStatus().name()))
                .products(restaurantApprovalRequestAvroModel.getProducts().stream()
                        .map(avroModel -> Product.Builder.builder()
                                .productId(new ProductId(UUID.fromString(avroModel.getId())))
                                .quantity(avroModel.getQuantity())
                                .build())
                        .toList())
                .price(restaurantApprovalRequestAvroModel.getPrice())
                .createdAt(restaurantApprovalRequestAvroModel.getCreatedAt())
                .build();
    }
}