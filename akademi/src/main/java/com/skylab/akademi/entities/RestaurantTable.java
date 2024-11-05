package com.skylab.akademi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="capacity")
    private int capacity;

    @Column(name="reserved_by")
    private String reservedBy;

    @Column(name="is_reserved")
    private boolean isReserved;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;


}
