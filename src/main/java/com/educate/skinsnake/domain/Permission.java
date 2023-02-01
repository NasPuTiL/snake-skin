package com.educate.skinsnake.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERMISSIONS")
@Setter(AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
public class Permission {
    @Id
    @GeneratedValue(generator = "PERMISSIONS_SEQ")
    @SequenceGenerator(name = "PERMISSIONS_SEQ", sequenceName = "PERMISSIONS_SEQ", allocationSize = 1)
    private Long permissionId;
    @Column(name = "PERMISSION_NAME", nullable = false)
    private String permission;

    @OneToMany(mappedBy = "permission")
    private List<UserRolePermission> userRolePermissionList;
}
