package com.crud.simple.dto;

import java.util.UUID;

public record PublishingDto(UUID id, Long likes, String comments, String img){
}
