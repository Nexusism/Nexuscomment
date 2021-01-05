package com.nexus.board.controller;

import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.UserRepository;
import com.nexus.board.dto.UserInfoDto;
import com.nexus.board.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
public class UserController {

    private UserRepository member;
    private UserService userService;


//    @GetMapping("/")  // 초기화면을 로그인화면으로
//    public String main() {
//        return "redirect:/list";
//    }
//    @GetMapping("/login")  // 초기화면을 메인으로할껀데 권한이없어서 로그인창이 출력됨?
//    public String login() {
//        return "/login.html";
//    }


    @PostMapping("/signIn")
    public String signIn(@AuthenticationPrincipal UserInfo userInfo, String inputEmail, String inputPassword) {
        System.out.printf("id : {}, pw : {}", inputEmail, inputPassword);
        userInfo = this.member.findByEmailAndPassword(inputEmail, inputPassword);
        System.out.println(userInfo);
        if (member != null) {
            return "board/list.html";
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
