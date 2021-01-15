package com.nexus.board.domain.repository;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.CommentEntity;
import com.nexus.board.dto.BoardDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    public List<CommentEntity> findByBoard_IdOrderByIdDesc(Long id);
}
