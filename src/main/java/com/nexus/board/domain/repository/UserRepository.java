package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserInfo, Long> {

   // @Query("select m from MemberEntity m where m.email = :email and m.password = :password")

    UserInfo findByEmailAndPassword(String email, String password);

    Optional<UserInfo> findByEmail(String email);
}
