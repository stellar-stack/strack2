package com.strack.strack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentid;
    private int os;
    private int analyticalthinking;
    private int cprogramming;
    private int linearalgebra;
    // Store the total in the DB
    private int total;

    // Update total before persisting or updating
    @PrePersist
    @PreUpdate
    public void updateTotal() {
        this.total = os + analyticalthinking + cprogramming + linearalgebra;
    }
}
