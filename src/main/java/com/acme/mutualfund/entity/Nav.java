package com.acme.mutualfund.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"fund_symbol", "date"}))
public class Nav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "fund_symbol")
    private Fund fund;
    private LocalDate date;
    @Column(precision = 19, scale = 6)
    private BigDecimal nav;
}
