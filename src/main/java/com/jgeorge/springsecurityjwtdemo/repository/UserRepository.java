package com.jgeorge.springsecurityjwtdemo.repository;

import com.jgeorge.springsecurityjwtdemo.entity.Role;
import com.jgeorge.springsecurityjwtdemo.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByEmail(String email);

  User findByRole(Role role);
}
