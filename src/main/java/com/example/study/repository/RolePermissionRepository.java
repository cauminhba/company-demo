package com.example.study.repository;

import com.example.study.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {
    List<RolePermission> findByRoleName(String roleName);
}
