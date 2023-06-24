package com.crud.simple.repository;

import com.crud.simple.models.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublishingRepository extends JpaRepository<Publishing, UUID> {
}
