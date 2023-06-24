package com.crud.simple.controllers;

import com.crud.simple.dto.PublishingDto;
import com.crud.simple.models.Publishing;
import com.crud.simple.services.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/publishing")
public class PublishingController {

    @Autowired
    PublishingService publishingService;

    @GetMapping("/{idPublishing}")
    public ResponseEntity<Publishing> getById(@PathVariable UUID idPublishing){
        return ResponseEntity.ok(publishingService.findLikeById(idPublishing));
    }

    @PostMapping
    public ResponseEntity<Publishing> save(@RequestBody PublishingDto publishingDto){
        return ResponseEntity.ok(publishingService.savePublishing(publishingDto));
    }


}
