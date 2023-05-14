package com.Service.Catalog.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table
public class Supplier {
    @Id
    @SequenceGenerator(
            name = "supplier_sequence",
            sequenceName = "supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "supplier_sequence"
    )

    private Long id;
    private String name;
    private String code;
    private String email;
    private String phone;

    public Supplier(String name, String code, String email, String phone) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.phone = phone;
    }
}
