package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.dto.BoardDto;
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
    Optional<LikeEntity> findByBidAndUid(BoardEntity bid, Long code);
    LikeEntity findByEmail(BoardDto bid);

    //LikeEntity findByUid(UserInfo uid);
    //LikeEntity findByUid_Code(Long uid);
    //LikeEntity findByEmailAndBidAndUid_Code(String email, BoardEntity bid, Long uid);
    LikeEntity findByLcheck(UserInfo uid);
    //boolean existsByEmailAndBidAndUid_Code(String email, BoardEntity bid, Long uid);

}
