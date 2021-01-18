package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    LikeEntity findByLcheck(Long lcheck);
    List<LikeEntity> findByBid(BoardEntity bid);

}
