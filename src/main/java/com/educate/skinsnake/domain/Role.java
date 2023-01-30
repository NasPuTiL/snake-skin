package com.educate.skinsnake.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROLES")
@Setter(AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
public class Role (Long roleId, String role, List<UserRolePermission> userRolePermissionList) {
    @Id
    @GeneratedValue(generator = "ROLES_SEQ")
    @SequenceGenerator(name = "ROLES_SEQ", sequenceName = "ROLES_SEQ", allocationSize = 1)
    private Long roleId;
    @Column(name = "ROLE_NAME", nullable = false)
    private String role;
    @OneToMany(mappedBy = "role")
    private List<UserRolePermission> userRolePermissionList;
}
