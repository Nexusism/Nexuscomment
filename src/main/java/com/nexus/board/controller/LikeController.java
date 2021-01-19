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
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String likeCheck(@PathVariable("no") BoardEntity no, @AuthenticationPrincipal UserInfo userInfo, LikeEntity likeEntity){
        @NotNull
        LikeDto lck = likeService.findUid(userInfo.getCode());
        //List<LikeEntity> likeEntity1 = likeRepository.findAll();
        //likeEntity = likeRepository.findByLcheck(userInfo.getCode());
        System.out.println("현재 ID의 Lcheck 여부 " + lck.getLcheck());
        //likeEntity.getLcheck();
        //LikeDto likeDto = new LikeDto();
        //System.out.println(likeRepository.findByLcheck(userInfo.getCode()));
        //BoardDto boardDto = boardService.getPost(lck.getBid().getId());
        //System.out.print("보드엔터티 ID =" + no.getId());
        //LikeDto like = likeService.findUid(userInfo.getCode());
        //List<LikeDto> like = likeService.getLikeList(no.getId());
        // Like Table의 현재 UserInfo의 id(uid)값을 불러와서 검색을해, 근데 그게 null이면 삽입하고, 중복이면 이미 추천하였습니다.

        //LikeDto likeDto = likeService.getLikeT(userInfo.getCode());
        //System.out.println("uid 값 = "+likeEntity1);
        //List<LikeDto> likes = likeService.getLikeBid(no);
        //LikeEntity allId = likeRepository.findAllByUid(userInfo.getCode());
        //LikeDto uids = likeService.findUid(userInfo);
        //System.out.print("Uid 리스트 : "+ allId);
//        if(likeEntity.getLcheck() == null){
//            LikeDto likeDto = new LikeDto();
//            System.out.print(likeDto.getLcheck());
//            likeDto.setEmail(userInfo.getEmail());
//            likeDto.setUid(userInfo);     //code
//            likeDto.setLcheck(1L);
//            likeDto.setBid(no);
//            likeService.saveLikeT(likeDto);
//        }else {
//            System.out.println("이미 추천하였습니다.");
//        }
        //LikeDto lids = likeService.getLikeT(no.getId());
        //System.out.print("BID : = " + likeRepository.findAllByBid(no));
        //System.out.print("좋아요 리스트 : "+ like);


        //System.out.print("좋아요 : "+ like);
//        if(userInfo.getEmail().equals(likes)) {
//            return "redirect:/";
//        }else {
//            LikeDto likeDto = new LikeDto();
//            System.out.print(likeDto.getLcheck());
//            likeDto.setEmail(userInfo.getEmail());
//            likeDto.setUid(userInfo);     //code
//            likeDto.setLcheck(1L);
//            likeDto.setBid(no);
//        }
//        if(userInfo.getEmail() == likeList.get(Math.toIntExact(no)).getEmail()){
//            System.out.print("이미 추천하였습니다.");
//        }else{
//            likeDto.setEmail(userInfo.getEmail());
//
//        }
//        if(like.getBid().getWriter() == no.getWriter()){
//            return "이미 추천하였습니다.";
//        }else{}

        //Long lc = boardService.plusLcount(boardDto);
        //boardService.savePost(boardDto);
        //likeService.saveLikeT(likeDto);
        //likeService.saveLikeT(likeDto);
        return "redirect:/post/{no}";
    }

}
