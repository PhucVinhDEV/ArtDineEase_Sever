package com.BitzNomad.identity_service.entity.Restaurant;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Order_Detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String descreption;

    int quantity;

    double totalPrice;

    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "productsize_id", nullable = false)
    ProductSize productSize;
}

enum Status {
    PENDING,
    COMPLETED,
    CANCELED
}
