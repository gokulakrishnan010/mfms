package com.acme.mutualfund.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username", "fund_symbol"}))
public class Holding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @ManyToOne(optional = false)
    @JoinColumn(name = "fund_symbol")
    private Fund fund;
    @Column(precision = 24, scale = 8, nullable = false)
    private BigDecimal units;

    @Version
    @Column(nullable = false)
    private long version;

    public static Holding newOf(String username, Fund fund) {
        return Holding.builder().username(username).fund(fund).units(BigDecimal.ZERO).build();
    }

    public void addUnits(BigDecimal u) {
        this.units = this.units.add(u);
    }

    public void subtractUnits(BigDecimal u) {
        this.units = this.units.subtract(u);
    }
}
