package com.nexus.board.service;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.BoardRepository;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.LikeDto;
import com.nexus.board.dto.UserInfoDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@AllArgsConstructor
//@RequiredArgsConstructor
@Service
public class LikeService {
    private LikeRepository likeRepository;
    private BoardRepository boardRepository;
    private BoardService boardService;


    private LikeDto convertEntityToDto(LikeEntity likeEntity) {
        return LikeDto.builder()
                .lid(likeEntity.getLid())
                .bid(likeEntity.getBid())
                .uid(likeEntity.getUid())
                .lcheck(likeEntity.getLcheck())
                .likecount(likeEntity.getLikecount())
                .email(likeEntity.getEmail())
                .build();
    }

    @Transactional
    public LikeDto getLikeT(Long bid) {
        Optional<LikeEntity> likeEntityWrapper = likeRepository.findById(bid);
        LikeEntity likeEntity = likeEntityWrapper.get();

        LikeDto likeDto = LikeDto.builder()
                .lid(likeEntity.getLid())
                .bid(likeEntity.getBid())
                .uid(likeEntity.getUid())
                .lcheck(likeEntity.getLcheck())
                .likecount(likeEntity.getLikecount())
                .email(likeEntity.getEmail())
                .build();

        return likeDto;
    }

    @Transactional
    public LikeDto getUserLike(Long no2, Long code, String email){
        BoardEntity board = boardRepository.findById(no2).get();
        Optional<LikeEntity> likeEntity = likeRepository.findByBidAndUidAndEmail(board, code, email);
        System.out.println("컨트롤러 체크2");
        if(likeEntity.isEmpty()){
            System.out.println("좋아요한적이없어요");
        }else {
            LikeDto likeDto = new LikeDto();
            likeDto.setBid(likeEntity.get().getBid());
            likeDto.setEmail(likeEntity.get().getEmail());
            likeDto.setLcheck(likeEntity.get().getLcheck());
            likeDto.setLikecount(likeEntity.get().getLikecount());
            likeDto.setUid(likeEntity.get().getUid());
            likeDto.setLid(likeEntity.get().getLid());
            System.out.println("해당 유저의 LikeDto값 : " + likeDto);
            System.out.println("라이크서비스 디테일 뷰" + likeRepository.findByBidAndUidAndEmail(board, code, email));

            return likeDto;
        }return null;
    }
        @Transactional
        public Long saveLikeT(LikeDto likeDto, BoardEntity no, UserInfo userInfo){
        BoardDto boardDto = new BoardDto();
        Long lCount = no.getLcount();
        Optional<LikeEntity> likeEntity = likeRepository.findByBidAndUid(no, userInfo.getCode());
        System.out.println("is Empty " + likeEntity.isEmpty());
        if (likeEntity.isEmpty()){
            System.out.println("라이크서비스의 Lcount " + lCount);
            boardDto.setId(no.getId());
            boardDto.setLcount(++lCount);
            boardDto.setWriter(userInfo.getEmail());
            boardDto.setTitle(no.getTitle());
            boardDto.setContent(no.getContent());
            System.out.println("라이크서비스의 boardDto" + boardDto);
            boardRepository.save(boardDto.toEntity());

            likeDto.setLcheck(1L);
            likeDto.setLikecount(1L);

            return likeRepository.save(likeDto.toEntity()).getLid();
        }else{
            System.out.println("이미 추천하였습니다.");
        }
            System.out.println("라이크서비스 로직 후 Dto값 " + likeDto);
        //        System.out.println("엔티티 이멜 :"+ likeEntity.get().getEmail());
        //        System.out.println("엔티티 유저코드 :"+ likeEntity.get().getUid());
        //        System.out.println("엔티티 BID :"+ likeEntity.get().getBid());
          return null;
        }
    }
