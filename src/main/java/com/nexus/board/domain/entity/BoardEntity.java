package com.nexus.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "like_count")
    //@ColumnDefault("0")
    private Long lcount;

//    @PrePersist
//    public void prePersist() {
//        this.lcount = this.lcount == null ? 0 : this.lcount;
//    }
      //최종본aaaaaa
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<CommentEntity> commentEntities = new ArrayList<CommentEntity>();

    @Builder
    public BoardEntity(Long id, String title, String content, String writer, Long lcount) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.lcount = lcount;
    }

    public void updates(String title, String content){
        this.title = title;
        this.content = content;
    }
}