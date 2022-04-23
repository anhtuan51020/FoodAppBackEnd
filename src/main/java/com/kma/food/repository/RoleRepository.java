package com.kma.food.repository;

import com.kma.food.domain.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findOneByRoleName(String roleName);
}
