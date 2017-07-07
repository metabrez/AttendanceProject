package edu.mum.cs.projects.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.Role;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Role findByRole(String role);
}
