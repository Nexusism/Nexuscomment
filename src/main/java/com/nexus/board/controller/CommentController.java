package com.nexus.board.controller;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.CommentRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.CommentDto;
import com.nexus.board.service.BoardService;
import com.nexus.board.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    //@PutMapping


    @PostMapping("/post/comment/")
    public String write(CommentDto commentDto) {
        commentService.saveComment(commentDto);
        return "redirect:/post/" + commentDto.getBoard().getId();
    }

}
