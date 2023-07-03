package com.Bander.inventory.inventory;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String inventoryName;
    @Column(updatable = false)
    private int capacity;
    private int currentStock;
    private String address;
    private String description;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNum;
    @Enumerated(value = EnumType.STRING)
    private InventoryType inventoryType;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime updatedTime;
    private boolean open;
}
