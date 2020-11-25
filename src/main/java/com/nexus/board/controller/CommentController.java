package com.nexus.board.controller;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.CommentEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.CommentRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.CommentDto;
import com.nexus.board.dto.UserInfoDto;
import com.nexus.board.service.BoardService;
import com.nexus.board.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@AllArgsConstructor
@Controller
public class CommentController {

    private CommentService commentService;
    private BoardService boardService;

    //@GetMapping("/post/comment/")
    //public String commentlist(Model model) {
    //  List<CommentDto> commentDtoList = commentService.getCommentlist();
    //model.addAttribute("commentDtoList", commentDtoList);
    // return "board/detail.html";
    //}
    @PostMapping("/post/comment/")
    public String write(@AuthenticationPrincipal UserInfo userInfo, CommentDto commentDto) {
        String username = userInfo.getUsername();
        //System.out.println(commentDto);
        commentDto.setWriter(username);
        commentService.saveComment(commentDto);

        return "redirect:/post/" + commentDto.getBoard().getId();
    }

    @DeleteMapping("/post/commentdelete/{cno}")
    public String delete(@PathVariable("cno") Long cno, @AuthenticationPrincipal UserInfoDto userInfoDto, BoardDto boardDto, CommentDto commentDto){
        //System.out.println(commentDto.getWriter());
        //System.out.println(cno);
        //System.out.println(boardDto);
        commentService.deleteComment(cno);
        return "redirect:/post/" + boardDto.getId();
   }

}
