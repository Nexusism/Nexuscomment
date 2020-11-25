package com.nexus.board.dto;

import com.nexus.board.domain.entity.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
    private Long code;
    private String email;
    private String password;
    private String auth;

    public UserInfo toEntityu(){
        UserInfo userInfo = UserInfo.builder()
                .code(code)
                .email(email)
                .password(password)
                .build();
        return userInfo;
    }

    @Builder
    public void UserInfo(Long code, String email, String password, String auth) {
        this.code = code;
        this.email = email;
        this.password = password;
        this.auth = auth;
    }
}
