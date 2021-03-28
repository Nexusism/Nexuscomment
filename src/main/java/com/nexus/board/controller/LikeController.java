package com.nexus.board.controller;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.domain.repository.UserRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.CommentDto;
import com.nexus.board.dto.LikeDto;
import com.nexus.board.service.BoardService;
import com.nexus.board.service.LikeService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
//@RequiredArgsConstructor
public class LikeController {
    private LikeRepository likeRepository;
    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private BoardService boardService;
    private LikeService likeService;

    @PostMapping("/post/like/{no}")
    public String likeCheck(@PathVariable("no") BoardEntity no, @AuthenticationPrincipal UserInfo userInfo, LikeDto likeDto, BoardDto boardDto){
        Long UserId = userInfo.getCode();
        String UserEmail = userInfo.getEmail();
        //Optional<BoardEntity> boardEntity = boardRepository.findById(no.getId());
        //System.out.println("보드엔티티 id" + boardEntity.get().getId());
        //System.out.println("보드엔티티 like count" + boardEntity.get().getLcount());
        likeDto.setUid(UserId);
        likeDto.setEmail(UserEmail);
        likeDto.setBid(no);

        System.out.println("라이크체크 UID =" + likeDto.getUid());
        likeService.saveLikeT(likeDto, no, userInfo);
        System.out.println(likeDto.getLcheck());
//        boardDto = boardService.plusLcount(no.getId());
//        Long lcount = no.getLcount();
//        boardDto.setLcount(++lcount);
//        boardService.savePost(boardDto);
        //System.out.println("보드 DTO : " + boardService.plusLcount(no.getId()));
        return "redirect:/post/{no}";
    }

}
