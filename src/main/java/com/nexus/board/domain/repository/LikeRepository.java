package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    LikeEntity findByLcheck(Long lcheck);
}
