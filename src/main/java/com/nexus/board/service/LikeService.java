package com.nexus.board.service;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.entity.UserInfo;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.LikeDto;
import com.nexus.board.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LikeService {
    private LikeRepository likeRepository;

//    @Transactional
//    public List<LikeDto> getLikeList(Long id) {
//        List<LikeEntity> likeEntities = likeRepository.findAll();
//        return getLikeList(likeEntities);
//    }

    @Transactional
    public List<LikeDto> getLikeBid(BoardEntity bid) {
        List<LikeEntity> likes = likeRepository.findByBid(bid);
        List<LikeDto> likeDtoBid = new ArrayList<>();

        if(likes.isEmpty()) return likeDtoBid;

        for(LikeEntity likeEntity : likes){
            likeDtoBid.add(this.convertEntityToDto(likeEntity));
        }
        return likeDtoBid;
    }

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
//    public LikeDto findUid(UserInfo uid) {
//        Optional<LikeEntity> likeEntityWrapper = likeRepository.findByUid(uid);
//        LikeEntity likeEntity = likeEntityWrapper.get();
//
//        LikeDto likeDto = LikeDto.builder()
//                .lid(likeEntity.getLid())
//                .bid(likeEntity.getBid())
//                .uid(likeEntity.getUid())
//                .lcheck(likeEntity.getLcheck())
//                .likecount(likeEntity.getLikecount())
//                .email(likeEntity.getEmail())
//                .build();
//
//        return likeDto;
//    }




    @Transactional
    public Long saveLikeT(LikeDto likeDto) {
        return likeRepository.save(likeDto.toEntity()).getLid();
    }
}
