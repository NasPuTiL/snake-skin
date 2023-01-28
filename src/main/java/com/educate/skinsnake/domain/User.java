package com.educate.skinsnake.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@Setter(AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
public class User {
    @Id
    @GeneratedValue(generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    private Long userId;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "ROLE", nullable = false)
    private String role;
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "user")
    private List<UserRolePermission> userRolePermissionList;
}
