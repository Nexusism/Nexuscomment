package com.nexus.board.domain.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "liketable")
public class LikeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long lid;

    @OneToOne
    @JoinColumn(name = "board_id")
    private BoardEntity bid;

    @Column(name = "code")
    private Long uid;

    @Column(name = "like_check")
    @ColumnDefault("0")
    private Long lcheck;

    @Column(name = "like_count")
    @ColumnDefault("0")
    private Long likecount;

    @Column(name = "e_mail")
    private String email;

    @Builder
    public LikeEntity(Long lid, BoardEntity bid, Long uid, Long lcheck, Long likecount, String email) {
        this.lid = lid;
        this.bid = bid;
        this.uid = uid;
        this.lcheck = lcheck;
        this.likecount = likecount;
        this.email = email;
    }

}
