package com.nexus.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @OneToOne
    @JoinColumn(name = "code")
    private UserInfo uid;

    @Column(name = "like_check")
    @ColumnDefault("0")
    private Long lcheck;


    @Builder
    public LikeEntity(Long lid, BoardEntity bid, UserInfo uid, Long lcheck) {
        this.lid = lid;
        this.bid = bid;
        this.uid = uid;
        this.lcheck = lcheck;
    }
}
