package com.nexus.board.service;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.CommentEntity;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.CommentRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Transactional
    public List<CommentDto> getCommentlist(Long id) {
        List<CommentEntity> commentEntities = commentRepository.findByBoard_IdOrderByIdDesc(id);
        List<CommentDto> commentDtoList = new ArrayList<>();

        for ( CommentEntity commentEntity : commentEntities) {
            CommentDto commentDto = CommentDto.builder()
                    .board(commentEntity.getBoard())
                    .id(commentEntity.getId())
                    .content(commentEntity.getContent())
                    .writer(commentEntity.getWriter())
                    .createdDate(commentEntity.getCreatedDate())
                    .build();

            commentDtoList.add(commentDto);
        }

        return commentDtoList;
    }

    @Transactional
    public CommentDto getComment(Long id) {
        Optional<CommentEntity> commentEntityWrapper = commentRepository.findById(id);
        CommentEntity commentEntity = commentEntityWrapper.get();
        CommentDto commentDto = CommentDto.builder()
                .board(commentEntity.getBoard())
                .id(commentEntity.getId())
                .content(commentEntity.getContent())
                .writer(commentEntity.getWriter())
                .createdDate(commentEntity.getCreatedDate())
                .build();

        return commentDto;
    }

    @Transactional
    public Long saveComment(CommentDto commentDto) {
        return commentRepository.save(commentDto.toEntityc()).getId();
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}