package com.mie.quickshop.repository.auth;

import com.mie.quickshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthRepository extends JpaRepository<User, Long> {
}
