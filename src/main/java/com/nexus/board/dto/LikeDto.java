package com.nexus.board.dto;


import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LikeDto {
    private Long lid;
    private BoardEntity bid;
    private UserInfo uid;
    private Long lcheck;
    private Long likecount;
    private String email;

    public LikeEntity toEntity(){
        LikeEntity likeEntity = LikeEntity.builder()
                .lid(lid)
                .bid(bid)
                .uid(uid)
                .lcheck(lcheck)
                .likecount(likecount)
                .email(email)
                .build();
        return likeEntity;
    }

    @Builder
    public LikeDto(Long lid, BoardEntity bid, UserInfo uid, Long lcheck, Long likecount, String email) {
        this.lid = lid;
        this.bid = bid;
        this.uid = uid;
        this.lcheck = lcheck;
        this.likecount = likecount;
        this.email = email;
    }

}
