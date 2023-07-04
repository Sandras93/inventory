package com.Bander.inventory.customer;

import com.Bander.inventory.inventory.InventoryEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customerName", "dateOfBirth", "phoneNum"})
})
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String customerName;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phoneNum;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Enumerated(value = EnumType.STRING)
    private CustomerGender customerGender;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime updatedTime;
    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventoryEntity> inventories = new ArrayList<>();
}
