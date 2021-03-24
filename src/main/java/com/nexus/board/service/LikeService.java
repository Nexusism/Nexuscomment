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

@AllArgsConstructor
//@RequiredArgsConstructor
@Service
public class LikeService {
    private LikeRepository likeRepository;
    private BoardRepository boardRepository;

//    @Transactional
//    public List<LikeDto> getLikeList(Long id) {
//        List<LikeEntity> likeEntities = likeRepository.findAll();
//        return getLikeList(likeEntities);
//    }

//    @Transactional
//    public List<LikeDto> getLikeBid(BoardEntity bid) {
//        List<LikeEntity> likes = likeRepository.findByBid(bid);
//        List<LikeDto> likeDtoBid = new ArrayList<>();
//
//        if (likes.isEmpty()) return likeDtoBid;
//
//        for (LikeEntity likeEntity : likes) {
//            likeDtoBid.add(this.convertEntityToDto(likeEntity));
//        }
//        return likeDtoBid;
//    }

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

//    @Transactional
//    public Boolean existData(Long uid, BoardEntity no, String email, UserInfo userInfo) {
//        System.out.println("서비스로넘어온 유저 id =" + uid);
//        System.out.println("서비스 getCode =" + userInfo.getCode());
//        Boolean aBoolean = likeRepository.existsByEmailAndBidAndUid_Code(email, no, userInfo.getCode());
//        System.out.println("UID 값은 = " + aBoolean);
//        return aBoolean;
//    }

    @Transactional
    public LikeDto findUid(Long uid, BoardEntity no, String email, UserInfo userInfo) {

//        LikeEntity likeEntity = likeRepository.findByEmailAndBidAndUid_Code(email, no, userInfo.getCode());
//        //Boolean bBoolean = existData(likeEntity.getUid().getCode());
//        //System.out.println("찾은 데이터의 LID값" + bBoolean);
//        System.out.println("조건에 다 맞는 데이터" + likeEntity);
//        System.out.println("좋아요 데이터 :" + likeEntity.getBid());
//        System.out.println("좋아요 데이터 :" + likeEntity.getEmail());
//        System.out.println("좋아요 데이터 :" + likeEntity.getUid());
//
        LikeDto likeDto = new LikeDto();
//        if(likeEntity.getBid() == no ||likeEntity.getEmail().equals(userInfo.getEmail())){
//            System.out.println("보드아이디가 같을때");
//            likeDto = this.convertEntityToDto(likeEntity);
//
//        }else{
//
//        }
//        System.out.println(likeEntity);
//        System.out.println("findService 디티오 생성");
//            System.out.println("값이 있는데 user code 같을때");

            //System.out.println("서비스 uid :" + uid);
            //System.out.println("새로운 LikeDto 생성");
            //System.out.println("현재 아이디 글 존재여부 : " + bBoolean);
            //return likeDto;


        return likeDto;
    }

        @Transactional
        public Long saveLikeT(LikeDto likeDto, BoardEntity no, UserInfo userInfo){

        Optional<LikeEntity> likeEntity = likeRepository.findByBidAndUid(no, userInfo.getCode());

        System.out.println("is Empty " + likeEntity.isEmpty());

        if (likeEntity.isEmpty()){
            likeDto.setLcheck(1L);
            likeDto.setLikecount(1L);
            return likeRepository.save(likeDto.toEntity()).getLid();
        }else{
            System.out.println("이미 추천하였습니다.");
        }
        //        System.out.println("엔티티 이멜 :"+ likeEntity.get().getEmail());
        //        System.out.println("엔티티 유저코드 :"+ likeEntity.get().getUid());
        //        System.out.println("엔티티 BID :"+ likeEntity.get().getBid());
          return null;
        }
    }
