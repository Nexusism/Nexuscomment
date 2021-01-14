package com.nexus.board.controller;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.domain.repository.UserRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.LikeDto;
import com.nexus.board.service.BoardService;
import com.nexus.board.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor

public class LikeController {
    private LikeRepository likeRepository;
    private UserRepository userRepository;
    private BoardRepository boardRepository;
    private BoardService boardService;
    private LikeService likeService;

    @PostMapping("/post/like/{no}")
    public String likeCheck(@PathVariable("no") Long no, @AuthenticationPrincipal UserInfo userInfo){
        System.out.print("날라온게 뭐냐 := {" + no + "}");
        BoardDto boardDto = boardService.getPost(no);
        LikeDto likeDto = likeService.getLikeT(no); // 새로운 like를 생성해서 넣어야하나?
        likeDto.setBid();
        likeDto.setEmail();
        likeDto.setUid();
        System.out.print("LikeBid = " + boardDto);
        System.out.println("LikeLid =" + likeDto);

//        if(like.getBid().getWriter() == no.getWriter()){
//            return "이미 추천하였습니다.";
//        }else{
//
//        }
        //Long lc = boardService.plusLcount(boardDto);
        //System.out.println(lc);
        //String username = userInfo.getUsername();
        //like.setBid(no.getid());           //board_id
        //like.setUid(userInfo);     //code
        //like.setLcheck(1L);        //like_check
        //like.setEmail(username);   //e_mail
        //System.out.println(boardDto);
        //boardService.savePost(boardDto);
        //likeService.saveLikeT(likeDto);

        return "redirect:/post/{no}";
    }

}
