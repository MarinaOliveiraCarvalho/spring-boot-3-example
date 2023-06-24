package com.crud.simple.services;

import com.crud.simple.dto.PublishingDto;
import com.crud.simple.models.Publishing;
import com.crud.simple.repository.PublishingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Service
public class PublishingService {

    @Autowired
    PublishingRepository likeRepository;

    public Publishing findLikeById(UUID idPublishing){
        try {
            log.info("find publishing");
            return likeRepository.findById(idPublishing).orElseThrow();
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," ERROR on find idPublishing: " + idPublishing );
        }
    }

    public Publishing savePublishing(PublishingDto publishingDto){
        try {
            log.info("saved new publishing");
            return likeRepository.save(newPublishing(publishingDto));
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST," ERROR on create publishing ");
        }
    }

    private Publishing newPublishing(PublishingDto publishingDto){
        try {
            var publishing = new Publishing();
            BeanUtils.copyProperties(publishingDto, publishing);
            return publishing;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new RuntimeException("ERROR on create publishing");
        }
    }


    public Publishing addLikeById(UUID idPublishing){
        try {
            log.info("add like on publishing: {}", idPublishing);
            Publishing publishing = findLikeById(idPublishing);
            publishing.setLikes(publishing.getLikes() + 1);
            return likeRepository.saveAndFlush(publishing);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," ERROR add Like on publishing: " + idPublishing );
        }
    }

    public Publishing removeLikeById(UUID idPublishing){
        try {
            log.info("remove like on publishing: {}", idPublishing);
            Publishing publishing = findLikeById(idPublishing);
            if(publishing.getLikes() > 0 ){
                publishing.setLikes(publishing.getLikes() + 1);
                return likeRepository.saveAndFlush(publishing);
            }
            return publishing;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," ERROR remove like on publishing: " + idPublishing );
        }
    }

}
