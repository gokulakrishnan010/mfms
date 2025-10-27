package com.acme.mutualfund.fund;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Fund {
  @Id private String symbol;
  private String name;
}
