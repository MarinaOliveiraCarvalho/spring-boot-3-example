package com.crud.simple.controllers;

import com.crud.simple.models.Publishing;
import com.crud.simple.services.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    PublishingService publishingService;

    @GetMapping("/add/{idPublishing}")
    public ResponseEntity<Publishing> addById(@PathVariable UUID idPublishing){
        return ResponseEntity.ok(publishingService.addLikeById(idPublishing));
    }

    @GetMapping("/async/add/{idPublishing}")
    public ResponseEntity<Publishing> asyncAddById(@PathVariable UUID idPublishing){
        publishingService.asyncAddLikeById(idPublishing);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/remove/{idPublishing}")
    public ResponseEntity<Publishing> removeById(@PathVariable UUID idPublishing){
        return ResponseEntity.ok(publishingService.removeLikeById(idPublishing));
    }
}
