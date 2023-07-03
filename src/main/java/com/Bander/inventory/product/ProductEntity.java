package com.Bander.inventory.product;

import com.Bander.inventory.customer.CustomerGender;
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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"manufacturer","productName"})})
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productName;
    private String description;
    private int price;
    private int quantity;
    private String manufacturer;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime updatedTime;

    private boolean available;
}
