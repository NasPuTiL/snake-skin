package com.educate.skinsnake.applkcation.user;

import com.educate.skinsnake.config.SecurityUser;
import com.educate.skinsnake.domain.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new SecurityUser(user.getUsername(), user.getPassword(), providePermissions(user)))
                    .orElseThrow(() -> {
                    log.error("Username not found {}", username);
                    return new UsernameNotFoundException(String.format("Username not found %s.", username));
                });
    }

    private List<String> providePermissions(User user) {
        String roleName = Optional.of(user.getRole()).map(Role::getRole).get();
        List<String> permissions = user.getRole().getUserRolePermissionList().stream()
                .map(UserRolePermission::getPermission)
                .map(Permission::getPermission)
                .collect(Collectors.toList());
        permissions.add(roleName);
        return permissions;
    }
}
