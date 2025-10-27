package com.acme.mutualfund.portfolio;

import com.acme.mutualfund.fund.Fund;
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
    @Column(precision = 19, scale = 6)
    private BigDecimal units;
    @Version
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
