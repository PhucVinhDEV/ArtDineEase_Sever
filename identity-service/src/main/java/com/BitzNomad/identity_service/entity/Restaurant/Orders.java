package com.BitzNomad.identity_service.entity.Restaurant;

import com.BitzNomad.identity_service.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Orders extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    LocalDateTime startTime;
    LocalDateTime endTime;

    BigDecimal price;

    boolean StatusOfOrder;

    @ManyToOne
    @JoinColumn(name = "TableOfRestaurant_id")
    TableOfRestaurant tables;

    @OneToMany(mappedBy = "orders")
    Set<OrderDetail> orderDetails;
}
