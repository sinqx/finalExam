package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "citizen", nullable = false)
    private Citizen citizen;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "recorded", nullable = false)
    private LocalDateTime recorded;
}
