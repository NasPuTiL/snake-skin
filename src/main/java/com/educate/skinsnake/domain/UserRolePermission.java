package com.educate.skinsnake.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_ROLE_PERMISSIONS")
@Setter(AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
public class UserRolePermission {
    @Id
    @GeneratedValue(generator = "USER_ROLE_PERMISSIONS_SEQ")
    @SequenceGenerator(name = "USER_ROLE_PERMISSIONS_SEQ", sequenceName = "USER_ROLE_PERMISSIONS_SEQ", allocationSize = 1)
    private Long userRolePermissionId;
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "PERMISSION_ID", nullable = false)
    private Permission permission;
}
