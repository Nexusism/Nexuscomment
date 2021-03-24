package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    BoardEntity findById(BoardEntity no);
    //public String findAllByCommentEntitiesAndWriter(Long id);


}