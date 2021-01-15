package com.nexus.board.service;

import com.nexus.board.domain.entity.BoardEntity;
import com.nexus.board.domain.entity.LikeEntity;
import com.nexus.board.domain.repository.LikeRepository;
import com.nexus.board.dto.BoardDto;
import com.nexus.board.dto.LikeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LikeService {
    private LikeRepository likeRepository;

    @Transactional
    public List<LikeDto> getLikelist() {
        List<LikeEntity> likeEntities = likeRepository.findAll();
        List<LikeDto> likeDtoList = new ArrayList<>();

        for ( LikeEntity likeEntity : likeEntities) {
            LikeDto likeDto = LikeDto.builder()
                    .lid(likeEntity.getLid())
                    .bid(likeEntity.getBid())
                    .uid(likeEntity.getUid())
                    .lcheck(likeEntity.getLcheck())
                    .likecount(likeEntity.getLikecount())
                    .email(likeEntity.getEmail())
                    .build();

            likeDtoList.add(likeDto);
        }

        return likeDtoList;
    }

//    @Transactional
//    public List<LikeDto> getLikeT(Long lid) {
//        List<LikeEntity> likeEntities2 = likeRepository.findById(lid);
//        List<LikeDto> likeDtoList2 = new ArrayList<>();
//
//        for ( LikeEntity likeEntity : likeEntities2) {
//            LikeDto likeDto = LikeDto.builder()
//                    .lid(likeEntity.getLid())
//                    .bid(likeEntity.getBid())
//                    .uid(likeEntity.getUid())
//                    .lcheck(likeEntity.getLcheck())
//                    .likecount(likeEntity.getLikecount())
//                    .email(likeEntity.getEmail())
//                    .build();
//            likeDtoList2.add(likeDto);
//        }
//        return likeDtoList2;
//    }

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
    public Long saveLikeT(LikeDto likeDto) {
        return likeRepository.save(likeDto.toEntity()).getLid();
    }
}
