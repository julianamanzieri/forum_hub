package com.julianamanzieri.forum_hub.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    UserRecord findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select u from User u where u.email = :email")
    User getReferenceByEmail(@Param("email") String email);
}
