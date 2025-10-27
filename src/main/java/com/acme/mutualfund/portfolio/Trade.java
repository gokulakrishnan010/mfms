package com.acme.mutualfund.portfolio;

import com.acme.mutualfund.fund.Fund;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Trade {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  private String username;
  @ManyToOne(optional = false) @JoinColumn(name = "fund_symbol") private Fund fund;
  @Enumerated(EnumType.STRING) private TransactionType type;
  @Column(precision = 19, scale = 6) private BigDecimal units;
  @Column(precision = 19, scale = 6) private BigDecimal nav;
  @Column(precision = 19, scale = 6) private BigDecimal amount;
  private Instant ts;

  public static Trade buy(String username, Fund fund, BigDecimal units, BigDecimal nav, BigDecimal amount){
    return Trade.builder().username(username).fund(fund).type(TransactionType.BUY).units(units).nav(nav).amount(amount).ts(Instant.now()).build();
  }
  public static Trade redeem(String username, Fund fund, BigDecimal units, BigDecimal nav, BigDecimal amount){
    return Trade.builder().username(username).fund(fund).type(TransactionType.REDEEM).units(units).nav(nav).amount(amount).ts(Instant.now()).build();
  }
}
