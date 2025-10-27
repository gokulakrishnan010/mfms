package com.acme.mutualfund.auth;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {
    @Id
    private String username;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    private boolean enabled = true;
}
