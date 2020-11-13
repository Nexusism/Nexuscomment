package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.CommentEntity;
import com.nexus.board.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

   // @Query("select m from MemberEntity m where m.email = :email and m.password = :password")

    MemberEntity findByEmailAndPassword(String email, String password);
}
