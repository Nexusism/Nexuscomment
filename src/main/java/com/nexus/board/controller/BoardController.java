package com.nexus.board.controller;

import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.CommentDto;
import com.nexus.board.dto.UserInfoDto;
import com.nexus.board.service.BoardService;
import com.nexus.board.service.CommentService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    private CommentService commentService;
    private LikeRepository likeRepository;


    //@GetMapping("/list")  // list.html로
    @GetMapping("/")  // list.html로
    public String list(@AuthenticationPrincipal UserInfo user, Model model) {
        System.out.println("username = " + user.getUsername());
        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);
        return "/main";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);
        List<CommentDto> commentDto = commentService.getCommentlist(no);
        //System.out.println(commentDto);
        model.addAttribute("commentList", commentDto);
        model.addAttribute("boardDto", boardDTO);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, @AuthenticationPrincipal UserInfo userInfo, Model model, BoardDto boardDto) {
        String username = userInfo.getUsername();
        String bedit = boardDto.getWriter();
        if(username.equals(bedit)){
            boardDto = boardService.getPost(no);
            model.addAttribute("boardDto", boardDto);
        }else{
            return "editFail.html";
        }

        return "board/update.html";
    }

    @GetMapping("/boarddeleteFail/")
    public String bdeleteFail(){
        return "redirect:/boarddeleteFail.html";
    }

    @GetMapping("/editFail/")
    public String beditFail(){
        return "redirect:/editFail.html";
    }

    @PostMapping("/post/edit/{no}")
    public String update(@PathVariable("no") Long no, @AuthenticationPrincipal UserInfo userInfo, BoardDto boardDto) {
        String username = userInfo.getUsername();
        String bupdate = boardDto.getWriter();
        //System.out.println(username);
        //System.out.println(bupdate);
        if(username.equals(bupdate)){
            boardService.savePost(boardDto);
        }else{
            return "/editFail";
        }


        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no, @AuthenticationPrincipal UserInfo userInfo, BoardDto boardDto){
        String username = userInfo.getUsername();
        String bwriter = boardDto.getWriter();
        //System.out.println(username);
        //System.out.println(bwriter);
        //System.out.println(no);

        if(username.equals(bwriter)){
            boardService.deletePost(no);
        }else{
            return "/boarddeleteFail";
        }
        return "redirect:/";
    }

    @PostMapping("/post")
    public String write(@AuthenticationPrincipal UserInfo userInfo, BoardDto boardDto) {
        String username = userInfo.getUsername();
        //System.out.println(username);
        boardDto.setWriter(username);
        boardService.savePost(boardDto);
        return "redirect:/";
    }

//    @PostMapping("/post")
//    public String write(BoardDto boardDto) {
//        boardService.savePost(boardDto);
//
//        return "redirect:/list";
//    }
}