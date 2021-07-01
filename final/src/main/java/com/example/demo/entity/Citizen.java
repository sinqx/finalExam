package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "citizen")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @OneToOne
    @JoinColumn(name = "vaccine")
    private Vaccine Vaccine;

    @Column(name = "infected")
    private Boolean infected;

    @ManyToOne
    @JoinColumn(name = "region", nullable = false)
    private Region region;
}
