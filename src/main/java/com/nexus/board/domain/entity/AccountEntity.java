package com.nexus.board.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String username;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String password;



}
