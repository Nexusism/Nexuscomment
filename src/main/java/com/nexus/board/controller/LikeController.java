package com.nexus.board.controller;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.domain.repository.UserRepository;
import com.nexus.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor

public class LikeController {
    private LikeRepository likeRepository;
    private UserRepository userRepository;
    private BoardRepository boardRepository;

    @PostMapping("/post/like/{no}")
    public String likeCheck(@PathVariable("no") Long no, @AuthenticationPrincipal UserInfo userInfo, BoardDto boardDto, LikeEntity likeEntity){
        String username = userInfo.getUsername();
        Long like = likeEntity.getLcheck();
        System.out.printf(username);
        System.out.print(like);

        return "redirect:/";
    }

}
