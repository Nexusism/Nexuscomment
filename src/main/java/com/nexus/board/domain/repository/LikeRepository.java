package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.dto.LikeDto;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    LikeEntity findByLcheck(Long lcheck);
    List<LikeEntity> findByBid(BoardEntity bid);
    LikeEntity findAllByUid(Long uid);
    LikeEntity findByLcheck(UserInfo uid);

}
