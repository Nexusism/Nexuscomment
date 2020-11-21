package com.nexus.board.controller;

import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.UserRepository;
import com.nexus.board.dto.UserInfoDto;
import com.nexus.board.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
public class UserController {

    private UserRepository member;
    private UserService userService;


    //@GetMapping("/")  // 초기화면을 로그인화면으로
    //public String login() {
      //  System.out.println(login());
        //return "board/list.html";

    //}

    @PostMapping("/signIn")
    public String signIn(String inputEmail, String inputPassword) {
        System.out.printf("id : {}, pw : {}", inputEmail, inputPassword);
        UserInfo member = this.member.findByEmailAndPassword(inputEmail, inputPassword);
        if (member != null) {
            return "redirect:/list";
        }
        return "login/loginFail.html";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signup.html";
    }

    @PostMapping("/user")
    public String create(UserInfoDto infoDto){
        userService.save(infoDto);
        return "redirect:/login";
    }

    // 추가
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
