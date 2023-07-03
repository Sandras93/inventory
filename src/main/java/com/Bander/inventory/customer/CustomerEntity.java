package com.Bander.inventory.customer;

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
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String customerName;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateOfBirth;
    @Enumerated(value = EnumType.STRING)
    private CustomerGender customerGender;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime createdTime;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH-mm")
    private LocalDateTime updatedTime;

    private boolean active;
}
