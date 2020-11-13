package com.nexus.board.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "member")
public class MemberEntity extends TimeEntity {


    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String username;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String password;


    @Builder
    public MemberEntity(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

