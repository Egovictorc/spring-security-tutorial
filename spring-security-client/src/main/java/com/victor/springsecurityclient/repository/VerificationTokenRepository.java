package com.victor.springsecurityclient.repository;

import com.victor.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository  extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
