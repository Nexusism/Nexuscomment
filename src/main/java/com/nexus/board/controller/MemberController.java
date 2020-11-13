package com.nexus.board.controller;

import com.nexus.board.domain.entity.MemberEntity;
import com.nexus.board.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberRepository member;


    @GetMapping("/login")
    public String login() {
        //  System.out.println(login());
        return "login/login.html";

    }

    @PostMapping("/signIn")
    public String signIn(String inputEmail, String inputPassword) {
        System.out.printf("id : {}, pw : {}", inputEmail, inputPassword);
        MemberEntity member = this.member.findByEmailAndPassword(inputEmail, inputPassword);
        if (member != null) {
            return "login/loginOK.html";
        }
        return "login/loginFail.html";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "login/signup.html";
    }

    @RequestMapping("signUp/create")
    public String create(MemberEntity member){
        this.member.save(member);
        return "login/login.html";
    }
}
