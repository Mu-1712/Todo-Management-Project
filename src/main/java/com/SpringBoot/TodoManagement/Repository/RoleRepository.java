package com.SpringBoot.TodoManagement.Repository;

import com.SpringBoot.TodoManagement.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
